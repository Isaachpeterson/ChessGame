import React from 'react';
import './App.css';
import Board from './components/Board';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <h1>Chess Game</h1>
      </header>
      <Board />
    </div>
  );
}

export default App;