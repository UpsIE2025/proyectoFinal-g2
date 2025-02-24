import * as AuthSession from 'expo-auth-session';
import * as WebBrowser from 'expo-web-browser';

const config = {
  clientId: "veWikno6x9JnPuVvSGqx7thUg3IgAfUf",
  domain: "dev-88x6n0ntfccbwhfp.us.auth0.com",
};

// Crear el cliente de autenticación
const useProxy = true;
const redirectUri = AuthSession.makeRedirectUri({ useProxy });

const discovery = {
  authorizationEndpoint: `https://${config.domain}/authorize`,
  tokenEndpoint: `https://${config.domain}/oauth/token`,
};

const authClient = new AuthSession.AuthRequest({
  clientId: config.clientId,
  redirectUri,
  responseType: AuthSession.ResponseType.Token,
  scopes: ['openid', 'profile', 'email'],
  extraParams: {
    nonce: 'nonce',
  },
  discovery,
});

export const logInAsync = async () => {
  try {
    const result = await authClient.promptAsync({ useProxy });
    
    if (result.type === 'success') {
      return result.params;
    }
    return null;
  } catch (error) {
    console.error('Error:', error);
    return null;
  }
};