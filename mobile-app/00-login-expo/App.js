import React, { useState } from 'react';
import { Alert, Button, StyleSheet, Text, View } from 'react-native';
import { logInAsync } from './auth';
import * as WebBrowser from 'expo-web-browser';

WebBrowser.maybeCompleteAuthSession();

const App = () => {
  const [user, setUser] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const onLogin = async () => {
    setIsLoading(true);
    try {
      const response = await logInAsync();
      if (response) {
        setUser(response);
        Alert.alert('Success', 'Logged in successfully!');
      }
    } catch (error) {
      console.error(error);
      Alert.alert('Error', 'Something went wrong');
    }
    setIsLoading(false);
  };

  const onLogout = () => {
    setUser(null);
  };

  if (isLoading) {
    return <View style={styles.container}><Text>Loading...</Text></View>;
  }

  return (
    <View style={styles.container}>
      <Text style={styles.header}>Auth0Sample - Login</Text>
      {user ? (
        <>
          <Text>You are logged in!</Text>
          <Text>Access Token: {user.access_token}</Text>
          <Button title="Log Out" onPress={onLogout} />
        </>
      ) : (
        <>
          <Text>You are not logged in</Text>
          <Button title="Log In" onPress={onLogin} />
        </>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
    padding: 20,
  },
  header: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

export default App;