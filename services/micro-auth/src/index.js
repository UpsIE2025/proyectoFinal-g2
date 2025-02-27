const express = require('express');
const jwt = require('jsonwebtoken');
const jwksClient = require('jwks-rsa');
require('dotenv').config();

const app = express();
app.use(express.json());

// Load environment variables
const AUTH0_DOMAIN = process.env.AUTH0_DOMAIN;
const AUTH0_AUDIENCE = process.env.AUTH0_AUDIENCE;

// Set up JWKS client to fetch Auth0's signing keys
const client = jwksClient({
  jwksUri: `https://${AUTH0_DOMAIN}/.well-known/jwks.json`
});

function getKey(header, callback) {
  client.getSigningKey(header.kid, function(err, key) {
    if (err) return callback(err);
    const signingKey = key.getPublicKey();
    callback(null, signingKey);
  });
}

// Endpoint to validate JWT from GraphQL Server
app.post('/validate', (req, res) => {
  const authHeader = req.headers.authorization;
  if (!authHeader) {
    return res.status(401).json({ error: 'No token provided' });
  }
  const token = authHeader.replace('Bearer ', '');
  jwt.verify(token, getKey, { audience: AUTH0_AUDIENCE, issuer: `https://${AUTH0_DOMAIN}/` }, (err, decoded) => {
    if (err) {
      return res.status(401).json({ error: 'Invalid Token', details: err.message });
    }
    // Retornar info del usuario
    return res.json({ valid:true, user: decoded });
  });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`micro-auth running on port ${PORT}`);
});
