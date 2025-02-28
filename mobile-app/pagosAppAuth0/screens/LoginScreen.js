import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, KeyboardAvoidingView, Platform, Alert } from 'react-native';
import { TextInput, Button } from 'react-native-paper';
import { LinearGradient } from 'expo-linear-gradient';
import * as WebBrowser from 'expo-web-browser';
import { useAuthRequest, makeRedirectUri } from 'expo-auth-session';
import AsyncStorage from '@react-native-async-storage/async-storage';

// Finaliza sesión del navegador si es necesario
WebBrowser.maybeCompleteAuthSession();

// Configuración de Auth0
const auth0ClientId = "veWikno6x9JnPuVvSGqx7thUg3IgAfUf";
const auth0Domain = "dev-88x6n0ntfccbwhfp.us.auth0.com";

const LoginScreen = ({ navigation }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  // Configuración de la solicitud de autenticación
  const [googleRequest, googleResponse, googlePromptAsync] = useAuthRequest(
    {
      clientId: auth0ClientId,
      redirectUri: makeRedirectUri({
        scheme: "paymentapp", // Asegúrate de que el esquema coincide con tu configuración de expo
        useProxy: true,  // Para evitar problemas con Expo Go en desarrollo
      }),
      responseType: 'token', // Usamos 'token' para obtener un access_token
      scopes: ['openid', 'profile', 'email'],
    },
    { authorizationEndpoint: `https://${auth0Domain}/authorize` }
  );

  const [facebookRequest, facebookResponse, facebookPromptAsync] = useAuthRequest(
    {
      clientId: auth0ClientId,
      redirectUri: makeRedirectUri({
        scheme: "paymentapp",
        useProxy: true,
      }),
      responseType: 'token', // Usamos 'token' para obtener un access_token
      scopes: ['openid', 'profile', 'email'],
    },
    { authorizationEndpoint: `https://${auth0Domain}/authorize?connection=facebook` }
  );

  useEffect(() => {
    // Manejo de la respuesta de Google o Facebook
    if (googleResponse?.type === 'success' || facebookResponse?.type === 'success') {
      const { access_token, expires_in } = googleResponse?.params || facebookResponse?.params;
      console.log('Login exitoso:', googleResponse?.params || facebookResponse?.params);

      // Guardar el token y su expiración
      AsyncStorage.setItem('access_token', access_token);
      AsyncStorage.setItem('expires_in', (Date.now() + expires_in * 1000).toString());

      Alert.alert('Inicio de sesión exitoso', 'Bienvenido a la app');
      navigation.navigate('Bienvenido');
    }
  }, [googleResponse, facebookResponse]);

  // Función de login con credenciales manuales
  const handleLogin = () => {
    if (username === '123' && password === '123') {
      navigation.navigate('Bienvenido');
    } else {
      alert('Credenciales incorrectas');
    }
  };

  return (
    <KeyboardAvoidingView behavior={Platform.OS === 'ios' ? 'padding' : 'height'} style={styles.container}>
      <LinearGradient colors={['#6200ee', '#3700b3']} style={styles.background}>
        <View style={styles.overlay}>
          <View style={styles.formContainer}>
            <Text style={styles.header}>Bienvenido</Text>
            <Text style={styles.subHeader}>Por favor ingresa tus credenciales</Text>

            <TextInput
              label="Usuario"
              value={username}
              onChangeText={setUsername}
              style={styles.input}
              mode="outlined"
              left={<TextInput.Icon name="account" />}
            />

            <TextInput
              label="Contraseña"
              value={password}
              onChangeText={setPassword}
              style={styles.input}
              secureTextEntry
              mode="outlined"
              left={<TextInput.Icon name="lock" />}
            />

            <Button mode="contained" onPress={handleLogin} style={styles.button}>
              Iniciar sesión
            </Button>

            {/* Botón para iniciar sesión con Google */}
            <Button
              mode="outlined"
              onPress={() => googleRequest && googlePromptAsync()}
              style={styles.googleButton}
              disabled={!googleRequest}
            >
              Iniciar sesión con Google
            </Button>

            {/* Botón para iniciar sesión con Facebook */}
            <Button
              mode="outlined"
              onPress={() => facebookRequest && facebookPromptAsync()}
              style={styles.facebookButton}
              disabled={!facebookRequest}
            >
              Iniciar sesión con Facebook
            </Button>

            <TouchableOpacity onPress={() => alert('Recuperar Contraseña')}>
              <Text style={styles.forgotPassword}>¿Olvidaste tu contraseña?</Text>
            </TouchableOpacity>
          </View>
        </View>
      </LinearGradient>
    </KeyboardAvoidingView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  background: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  overlay: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'rgba(0, 0, 0, 0.4)',
    width: '100%',
    height: '100%',
  },
  formContainer: {
    width: '85%',
    padding: 20,
    backgroundColor: 'white',
    borderRadius: 15,
    elevation: 5,
  },
  header: {
    fontSize: 28,
    fontWeight: 'bold',
    color: '#6200ee',
    marginBottom: 10,
    textAlign: 'center',
  },
  subHeader: {
    fontSize: 16,
    color: '#aaa',
    marginBottom: 20,
    textAlign: 'center',
  },
  input: {
    marginBottom: 15,
  },
  button: {
    marginTop: 15,
    backgroundColor: '#6200ee',
  },
  googleButton: {
    marginTop: 15,
    borderColor: '#6200ee',
    borderWidth: 1,
  },
  facebookButton: {
    marginTop: 15,
    borderColor: '#3b5998',
    borderWidth: 1,
  },
  forgotPassword: {
    marginTop: 15,
    color: '#6200ee',
    textAlign: 'center',
  },
});

export default LoginScreen;
