import React, { useState } from "react";

function CurrencyConvertor() {

  const [amount, setAmount] = useState("");
  const [currency, setCurrency] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    const euro = (amount / 90).toFixed(2);

    alert("Converting to Euro Amount is " + euro);

    setCurrency("Euro");
  };

  return (
    <div>

      <h1 style={{ color: "green" }}>
        Currency Convertor!!!
      </h1>

      <form onSubmit={handleSubmit}>

        <p>
          Amount
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </p>

        <p>
          Currency
          <input
            type="text"
            value={currency}
            readOnly
          />
        </p>

        <button type="submit">
          Submit
        </button>

      </form>

    </div>
  );
}

export default CurrencyConvertor;