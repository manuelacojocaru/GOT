import { useState } from 'react';

export default function WhiteWalkerPage() {
  const [addWhiteWalkerHeight, setAddWhiteWalkerHeight] = useState('');
  const [addWhiteWalkerPower, setAddWhiteWalkerPower] = useState('');
  const [addWhiteWalkerWeapon, setAddWhiteWalkerWeapon] = useState('SWORD');
  const [addWhiteWalkerIsKing, setAddWhiteWalkerIsKing] = useState(false);

  const [whiteWalkerById, setWhiteWalkerById] = useState('');

  const [deleteWhiteWalkerId, setDeleteWhiteWalkerId] = useState('');

  const [killWhiteWalkerId1, setKillWhiteWalkerId1] = useState('');
  const [killPersonId, setKillPersonId] = useState('');

  const [killWhiteWalkerId2, setKillWhiteWalkerId2] = useState('');
  const [killDragonId, setKillDragonId] = useState('');

  const [whiteWalkerWeapon, setWhiteWalkerWeapon] = useState('SWORD');

  const weapons = [
    'SWORD',
    'AXE',
    'BOW',
    'SPEAR',
    'DAGGER',
    'MACE',
    'HAMMER',
    'CROSSBOW',
    'ARROW',
    'GAUNTLET',
  ];

  const addWhiteWalker = () => {
    const post = async () => {
      try {
        const response = await fetch('http://localhost:8080/whiteWalker', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            height: addWhiteWalkerHeight,
            power: addWhiteWalkerPower,
            weapon: addWhiteWalkerWeapon,
            isKing: addWhiteWalkerIsKing,
            victims: 0,
          }),
        });
        const data = await response.json();
        console.log(data);
      } catch (err) {
        alert('error');
      }
    };
    post();
  };

  const getWhiteWalkerById = () => {
    const get = async () => {
      try {
        const response = await fetch(`http://localhost:8080/whiteWalker/${whiteWalkerById}`);
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const getAllWhiteWalkers = () => {
    const get = async () => {
      try {
        const response = await fetch('http://localhost:8080/whiteWalkers');
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const deleteWhiteWalker = () => {
    const del = async () => {
      try {
        const response = await fetch(`http://localhost:8080/whiteWalker/${deleteWhiteWalkerId}`, {
          method: 'DELETE',
        });
      } catch (err) {
        alert('error');
      }
    };
    del();
  };

  const killPerson = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/whiteWalker/${killWhiteWalkerId1}/killPerson/${killPersonId}`,
          {
            method: 'POST',
          }
        );
      } catch (err) {
        alert('error');
      }
    };
    post();
  };

  const killDragon = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/whiteWalker/${killWhiteWalkerId2}/killDragon/${killDragonId}`,
          {
            method: 'POST',
          }
        );
      } catch (err) {
        alert('error');
      }
    };
    post();
  };

  const getWhiteWalkersByWeapon = () => {
    const get = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/whiteWalkers/weapon/${whiteWalkerWeapon}`
        );
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  return (
    <div>
      <h1>White Walker Page</h1>
      <div class='flex'>
        <div class='forms'>
          <div className='form'>
            <h4>Add white walker</h4>
            <div>
              <input
                type='text'
                placeholder='Height'
                value={addWhiteWalkerHeight}
                onChange={(e) => setAddWhiteWalkerHeight(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Power'
                value={addWhiteWalkerPower}
                onChange={(e) => setAddWhiteWalkerPower(e.target.value)}
              />
            </div>
            <div>
              <select
                value={addWhiteWalkerWeapon}
                onChange={(e) => setAddWhiteWalkerWeapon(e.target.value)}
              >
                {weapons.map((weapon) => (
                  <option key={weapon} value={weapon}>
                    {weapon}
                  </option>
                ))}
              </select>
            </div>
            <div>
              <label htmlFor=''>Is king</label>
              <input
                type='checkbox'
                checked={addWhiteWalkerIsKing}
                onChange={(e) => setAddWhiteWalkerIsKing(e.target.checked)}
              />
            </div>
            <div>
              <button onClick={addWhiteWalker}>Add white walker</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get white walker by id</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={whiteWalkerById}
                onChange={(e) => setWhiteWalkerById(e.target.value)}
              />
            </div>
            <div>
              <button onClick={getWhiteWalkerById}>Get white walker by id</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get all white walkers</h4>
            <div>
              <button onClick={getAllWhiteWalkers}>Get all white walkers</button>
            </div>
          </div>
          <div className='form'>
            <h4>Delete white walker</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={deleteWhiteWalkerId}
                onChange={(e) => setDeleteWhiteWalkerId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={deleteWhiteWalker}>Delete white walker</button>
            </div>
          </div>
          <div className='form'>
            <h4>Kill person</h4>
            <div>
              <input
                type='text'
                placeholder='White walker id'
                value={killWhiteWalkerId1}
                onChange={(e) => setKillWhiteWalkerId1(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Person id'
                value={killPersonId}
                onChange={(e) => setKillPersonId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={killPerson}>Kill person</button>
            </div>
          </div>
          <div className='form'>
            <h4>Kill dragon</h4>
            <div>
              <input
                type='text'
                placeholder='White walker id'
                value={killWhiteWalkerId2}
                onChange={(e) => setKillWhiteWalkerId2(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Dragon id'
                value={killDragonId}
                onChange={(e) => setKillDragonId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={killDragon}>Kill dragon</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get white walkers by weapon</h4>
            <div>
              <select
                value={whiteWalkerWeapon}
                onChange={(e) => setWhiteWalkerWeapon(e.target.value)}
              >
                {weapons.map((weapon) => (
                  <option key={weapon} value={weapon}>
                    {weapon}
                  </option>
                ))}
              </select>
            </div>
            <div>
              <button onClick={getWhiteWalkersByWeapon}>Get white walkers by weapon</button>
            </div>
          </div>
        </div>
        <img src='whitewalker.jpg' alt='' className='right' />
      </div>
    </div>
  );
}
