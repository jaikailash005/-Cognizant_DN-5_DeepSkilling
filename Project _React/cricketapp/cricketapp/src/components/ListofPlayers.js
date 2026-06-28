import React from "react";

function ListofPlayers(props) {

    const players70 = props.players.filter(player => player.score <= 70);

    return (
        <div>
            <h1>List of Players</h1>

            <ul>
                {
                    props.players.map((item, index) => (
                        <li key={index}>
                            Mr. {item.name} <span>{item.score}</span>
                        </li>
                    ))
                }
            </ul>

            <hr />

            <h1>List of Players having Scores Less than 70</h1>

            <ul>
                {
                    players70.map((item, index) => (
                        <li key={index}>
                            Mr. {item.name} <span>{item.score}</span>
                        </li>
                    ))
                }
            </ul>
        </div>
    );
}

export default ListofPlayers;