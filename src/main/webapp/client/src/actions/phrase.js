import C from 'constants/phrase';

import * as api from 'services/api';

export function getAllPhrases() {
  return {
    types: [C.GET_PHRASES_REQUEST,
            C.GET_PHRASES_SUCCESS,
            C.GET_PHRASES_FAILURE],
    payload: {
      phrases: api.getAllPhrases().then(response => response)
    }
  };
}
