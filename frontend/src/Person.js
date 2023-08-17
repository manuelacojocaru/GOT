import { useState } from 'react';

export default function PersonPage() {
  const [addPersonName, setAddPersonName] = useState('');
  const [addPersonHeight, setAddPersonHeight] = useState('');
  const [addPersonPower, setAddPersonPower] = useState('');

  const [personById, setPersonById] = useState('');

  const [deletePersonId, setDeletePersonId] = useState('');

  const [killPeronsId, setKillPersonId] = useState('');
  const [killWhiteWalkerId, setKillWhiteWalkerId] = useState('');

  const addPerson = () => {
    const post = async () => {
      try {
        const response = await fetch('http://localhost:8080/person', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: addPersonName,
            height: addPersonHeight,
            power: addPersonPower,
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

  const getPersonById = () => {
    const get = async () => {
      try {
        const response = await fetch(`http://localhost:8080/person/${personById}`);
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const getAllPersons = () => {
    const get = async () => {
      try {
        const response = await fetch('http://localhost:8080/persons');
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const deletePerson = () => {
    const del = async () => {
      try {
        const response = await fetch(`http://localhost:8080/person/${deletePersonId}`, {
          method: 'DELETE',
        });
      } catch (err) {
        alert('error');
      }
    };
    del();
  };

  const killWhiteWalker = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/person/${killPeronsId}/killWhiteWalker/${killWhiteWalkerId}`,
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
      <h1>Person Page</h1>
      <div class='flex'>
        <div class='forms'>
          <div className='form'>
            <h4>Add person</h4>
            <div>
              <input
                type='text'
                placeholder='Name'
                value={addPersonName}
                onChange={(e) => setAddPersonName(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Height'
                value={addPersonHeight}
                onChange={(e) => setAddPersonHeight(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Power'
                value={addPersonPower}
                onChange={(e) => setAddPersonPower(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addPerson}>Add person</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get person by id</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={personById}
                onChange={(e) => setPersonById(e.target.value)}
              />
            </div>
            <div>
              <button onClick={getPersonById}>Get person by id</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get all persons</h4>
            <div>
              <button onClick={getAllPersons}>Get all persons</button>
            </div>
          </div>
          <div className='form'>
            <h4>Delete person by id</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={deletePersonId}
                onChange={(e) => setDeletePersonId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={deletePerson}>Delete person by id</button>
            </div>
          </div>
          <div className='form'>
            <h4>Kill whiteWalker</h4>
            <div>
              <input
                type='text'
                placeholder='Person id'
                value={killPeronsId}
                onChange={(e) => setKillPersonId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='WhiteWalker id'
                value={killWhiteWalkerId}
                onChange={(e) => setKillWhiteWalkerId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={killWhiteWalker}>Kill whiteWalker</button>
            </div>
          </div>
        </div>
        <img src='person.jpg' alt='' className='right-height' />
      </div>
    </div>
  );
}
