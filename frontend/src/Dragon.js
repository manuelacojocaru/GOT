import { useState } from 'react';

export default function DragonPage() {
  const [addDragonName, setAddDragonName] = useState('');
  const [addDragonColor, setAddDragonColor] = useState('');
  const [dragonById, setDragonById] = useState('');
  const [deleteDragonById, setDeleteDragonById] = useState('');
  const [fireDragonId, setFireDragonId] = useState('');
  const [firePersonId, setFirePersonId] = useState('');

  const addDragon = () => {
    const post = async () => {
      try {
        const response = await fetch('http://localhost:8080/dragon', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: addDragonName,
            color: addDragonColor,
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

  const getDragonById = () => {
    const get = async () => {
      try {
        const response = await fetch(`http://localhost:8080/dragon/${dragonById}`);
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const getAllDragons = () => {
    const get = async () => {
      try {
        const response = await fetch('http://localhost:8080/dragons');
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const deleteDragon = () => {
    const del = async () => {
      try {
        const response = await fetch(`http://localhost:8080/dragon/${deleteDragonById}`, {
          method: 'DELETE',
        });
      } catch (err) {
        alert('error');
      }
    };
    del();
  };

  const fire = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/dragon/${fireDragonId}/fire/${firePersonId}`,
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

  return (
    <div>
      <h1>Dragon page</h1>
      <div className='flex'>
        <div className='forms'>
          <div className='form'>
            <h4>Add/Update a dragon</h4>
            <div>
              <input
                type='text'
                name='name'
                placeholder='Name'
                value={addDragonName}
                onChange={(e) => setAddDragonName(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                name='color'
                placeholder='Color'
                value={addDragonColor}
                onChange={(e) => setAddDragonColor(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addDragon}>Add dragon</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get dragon by id</h4>
            <div>
              <input
                type='text'
                name='id'
                placeholder='Id'
                value={dragonById}
                onChange={(e) => setDragonById(e.target.value)}
              />
            </div>
            <div>
              <button onClick={getDragonById}>Get dragon</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get all dragons</h4>
            <div>
              <button onClick={getAllDragons}>Get dragons</button>
            </div>
          </div>
          <div className='form'>
            <h4>Delete a dragon</h4>
            <div>
              <input
                type='text'
                name='id'
                placeholder='Id'
                value={deleteDragonById}
                onChange={(e) => setDeleteDragonById(e.target.value)}
              />
            </div>
            <div>
              <button onClick={deleteDragon}>Delete dragon</button>
            </div>
          </div>
          <div className='form'>
            <h4>Fire</h4>
            <div>
              <input
                type='text'
                name='dragonId'
                placeholder='Dragon Id'
                value={fireDragonId}
                onChange={(e) => setFireDragonId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                name='personId'
                placeholder='Person Id'
                value={firePersonId}
                onChange={(e) => setFirePersonId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={fire}>Fire</button>
            </div>
          </div>
        </div>
        <img src='https://wallpaperaccess.com/full/476729.jpg' alt='' className='right' />
      </div>
    </div>
  );
}
