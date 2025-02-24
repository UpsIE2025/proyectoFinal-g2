const express = require('express');
const jwt = require('jsonwebtoken');
const jwksClient = require('jwks-rsa');

const app = express();

const client = jwksClient({
  jwksUri: 'https://<dominio-de-auth0_(DAVID_CLAVIJO)>/.well-known/jwks.json'
});

function getKey(header, callback) {
  client.getSigningKey(header.kid, function(err, key) {
    const signingKey = key.getPublicKey();
    callback(null, signingKey);
  });
}

app.get('/validate', (req, res) => {
  const authHeader = req.headers.authorization;
  if (!authHeader) {
    return res.status(401).json({ error: 'No token' });
  }
  const token = authHeader.replace('Bearer ', '');
  jwt.verify(token, getKey, { audience: '<CLIENT_ID>', issuer: 'https://<dominio-de-auth0_(DAVID_CLAVIJO)>/' }, (err, decoded) => {
    if (err) {
      return res.status(401).json({ error: 'Token invalid', details: err });
    }
    // Retornar info del usuario
    return res.json({ user: decoded });
  });
});

app.listen(3000, () => {
  console.log('micro-auth running on port 3000');
});
