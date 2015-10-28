import React, { Component, PropTypes } from 'react';
import Phrase from 'components/Phrase';

export default class PhraseList extends Component {
  static propTypes = {
    phrases: PropTypes.shape({
      word: PropTypes.string,
      description: PropTypes.string,
      example: PropTypes.string,
      author: PropTypes.string,
      votes: PropTypes.shape({
        up: PropTypes.number,
        down: PropTypes.number
      })
    })
  }

  render() {
    const { phrases } = this.props;
    return (<ul>
        {Object.keys(phrases).map(phraseId => (
          <Phrase key={phraseId} {...phrases[phraseId]} />
        ))}
      </ul>);
  }
}
