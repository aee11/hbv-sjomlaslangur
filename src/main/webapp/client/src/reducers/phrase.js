import { createReducer } from 'utils';
import {
  GET_PHRASES_REQUEST,
  GET_PHRASES_SUCCESS,
  GET_PHRASES_FAILURE
} from 'constants/phrase';

const initialState = {
  isFetching: false,
  phrases: {}
};
export default createReducer(initialState, {
  [GET_PHRASES_REQUEST]: (state) => ({
    ...state,
    isFetching: true
  }),
  [GET_PHRASES_SUCCESS]: (state, { phrases }) => ({
    ...state,
    isFetching: false,
    phrases: phrases.reduce((obj, phrase) => {
      obj[phrase.id] = phrase;
      return obj;
    }, {})
  }),
  [GET_PHRASES_FAILURE]: (state, { message }) => ({
    ...state,
    isFetching: false,
    errorMessage: message
  })
});
