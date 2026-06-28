import React from "react";
import ListofPlayers from "./components/ListofPlayers";
import {
  OddPlayers,
  EvenPlayers,
  IndianPlayers,
  ListofIndianPlayers,
} from "./components/IndianPlayers";

function App() {
  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 },
  ];

  const IndianTeam = [
    "Sachin",
    "Dhoni",
    "Virat",
    "Rohit",
    "Yuvraj",
    "Raina",
  ];

const flag = false;
  return (
    <div>
      {flag ? (
        <ListofPlayers players={players} />
      ) : (
        <div>
          <h1>Indian Team</h1>

          <h2>Odd Players</h2>
          {OddPlayers(IndianTeam)}

          <hr />

          <h2>Even Players</h2>
          {EvenPlayers(IndianTeam)}

          <hr />

          <h2>List of Indian Players Merged</h2>
          <ListofIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      )}
    </div>
  );
}

export default App;