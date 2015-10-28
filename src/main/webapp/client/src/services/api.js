import fetch from 'isomorphic-fetch';

export function getAllPhrases() {
  return fetch('http://localhost:8080/phrases')
    .then(res => {
      if (res.ok) {
        return res.json();
      } else {
        throw new Error('Get request failed');
      }
    });
}
