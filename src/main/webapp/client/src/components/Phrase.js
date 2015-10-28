import React, { Component, PropTypes } from 'react';

export default class Phrase extends Component {
  static propTypes = {
    word: PropTypes.string,
    description: PropTypes.string,
    example: PropTypes.string,
    author: PropTypes.string,
    votes: PropTypes.shape({
      up: PropTypes.number,
      down: PropTypes.number
    })
  }

  render() {
    const {
      word, description
    } = this.props;
    return <li><h3>{word}</h3><br /><p>{description}</p></li>;
  }
}
