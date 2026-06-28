import React, { useState } from "react";

import Greeting from "./components/Greeting";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";

function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);

  function login() {
    setIsLoggedIn(true);
  }

  function logout() {
    setIsLoggedIn(false);
  }

  return (

    <div style={{ margin: "40px" }}>

      <Greeting isLoggedIn={isLoggedIn} />

      <br />

      {isLoggedIn ? (

        <LogoutButton onClick={logout} />

      ) : (

        <LoginButton onClick={login} />

      )}

    </div>

  );
}

export default App;