import React, { Component, PropTypes } from 'react';
import { bindActionCreators } from 'redux';
import { connect }            from 'react-redux';
import PhraseList from 'components/PhraseList';
import * as phraseActionCreators from 'actions/phrase';

const mapStateToProps = (state) => ({
  phrases : state.phrase.phrases,
  isFetching : state.phrase.isFetching,
  routerState : state.router
});
const mapDispatchToProps = (dispatch) => ({
  actions : bindActionCreators(phraseActionCreators, dispatch)
});
export class PhraseListContainer extends Component {
  static propTypes = {
    actions  : PropTypes.object,
    isFetching: PropTypes.boolean,
    phrases  : PropTypes.object
  }

  componentWillMount() {
    this.props.actions.getAllPhrases();
  }

  render () {
    const {
      isFetching, phrases, actions
    } = this.props;
    if (isFetching) {
      return <h1>Loading phrases</h1>;
    }
    if (!phrases || Object.keys(phrases).length === 0) {
      return <h1>No phrases available</h1>;
    }
    return <PhraseList phrases={phrases} {...actions} />;
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(PhraseListContainer);
