import { combineReducers } from 'redux';
import counter from './counter';
import phrase from './phrase';
import { routerStateReducer } from 'redux-router';

export default combineReducers({
  phrase,
  counter,
  router: routerStateReducer
});
