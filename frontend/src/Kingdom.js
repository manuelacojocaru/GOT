import { useState } from 'react';

export default function KingdomPage() {
  const [addKingdomName, setAddKingdomName] = useState('');

  const [kingdomById, setKingdomById] = useState('');

  const [deleteKingdomId, setDeleteKingdomId] = useState('');

  const [kingdomId1, setKingdomId1] = useState('');
  const [kingdomId2, setKingdomId2] = useState('');

  const [addPeopleToKingdomId, setAddPeopleToKingdomId] = useState('');
  const [addPeoplId, setAddPeopleId] = useState('');

  const [addKingToKingdomId, setAddKingToKingdomId] = useState('');
  const [addKingId, setAddKingId] = useState('');

  const [addQueenToKingdomId, setAddQueenToKingdomId] = useState('');
  const [addQueenId, setAddQueenId] = useState('');

  const [addKingHandToKingdomId, setAddKingHandToKingdomId] = useState('');
  const [addKingHandId, setAddKingHandId] = useState('');

  const addKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch('http://localhost:8080/kingdom', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: addKingdomName,
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

  const getKingdomById = () => {
    const get = async () => {
      try {
        const response = await fetch(`http://localhost:8080/kingdom/${kingdomById}`);
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const getAllKingdoms = () => {
    const get = async () => {
      try {
        const response = await fetch('http://localhost:8080/kingdoms');
        const data = await response.json();
        alert(JSON.stringify(data));
      } catch (err) {
        alert('error');
      }
    };
    get();
  };

  const deleteKingdom = () => {
    const del = async () => {
      try {
        const response = await fetch(`http://localhost:8080/kingdom/${deleteKingdomId}`, {
          method: 'DELETE',
        });
      } catch (err) {
        alert('error');
      }
    };
    del();
  };

  const attackKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/kingdom/${kingdomId1}/attack/${kingdomId2}`,
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

  const addPeopleToKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/kingdom/${addPeopleToKingdomId}/addPerson/${addPeoplId}`,
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

  const addKingToKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/kingdom/${addKingToKingdomId}/setKing/${addKingId}`,
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

  const addQueenToKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/kingdom/${addQueenToKingdomId}/setQueen/${addQueenId}`,
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

  const addKingHandToKingdom = () => {
    const post = async () => {
      try {
        const response = await fetch(
          `http://localhost:8080/kingdom/${addKingHandToKingdomId}/setKingHand/${addKingHandId}`,
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
      <h1>Kingdom Page</h1>
      <div className='flex'>
        <div class='forms'>
          <div className='form'>
            <h4>Add kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Name'
                value={addKingdomName}
                onChange={(e) => setAddKingdomName(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addKingdom}>Add</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get kingdom by id</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={kingdomById}
                onChange={(e) => setKingdomById(e.target.value)}
              />
            </div>
            <div>
              <button onClick={getKingdomById}>Get</button>
            </div>
          </div>
          <div className='form'>
            <h4>Get all kingdoms</h4>
            <div>
              <button onClick={getAllKingdoms}>Get</button>
            </div>
          </div>
          <div className='form'>
            <h4>Delete a kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={deleteKingdomId}
                onChange={(e) => setDeleteKingdomId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={deleteKingdom}>Delete</button>
            </div>
          </div>
          <div className='form'>
            <h4>Attack</h4>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={kingdomId1}
                onChange={(e) => setKingdomId1(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Id'
                value={kingdomId2}
                onChange={(e) => setKingdomId2(e.target.value)}
              />
            </div>
            <div>
              <button onClick={attackKingdom}>Attack</button>
            </div>
          </div>
          <div className='form'>
            <h4>Add people to kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Kingdom Id'
                value={addPeopleToKingdomId}
                onChange={(e) => setAddPeopleToKingdomId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='People Id'
                value={addPeoplId}
                onChange={(e) => setAddPeopleId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addPeopleToKingdom}>Add</button>
            </div>
          </div>
          <div className='form'>
            <h4>Add king to kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Kingdom Id'
                value={addKingToKingdomId}
                onChange={(e) => setAddKingToKingdomId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='King Id'
                value={addKingId}
                onChange={(e) => setAddKingId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addKingToKingdom}>Add</button>
            </div>
          </div>
          <div className='form'>
            <h4>Add queen to kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Kingdom Id'
                value={addQueenToKingdomId}
                onChange={(e) => setAddQueenToKingdomId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='Queen Id'
                value={addQueenId}
                onChange={(e) => setAddQueenId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addQueenToKingdom}>Add</button>
            </div>
          </div>
          <div className='form'>
            <h4>Add king hand to kingdom</h4>
            <div>
              <input
                type='text'
                placeholder='Kingdom Id'
                value={addKingHandToKingdomId}
                onChange={(e) => setAddKingHandToKingdomId(e.target.value)}
              />
            </div>
            <div>
              <input
                type='text'
                placeholder='King Hand Id'
                value={addKingHandId}
                onChange={(e) => setAddKingHandId(e.target.value)}
              />
            </div>
            <div>
              <button onClick={addKingHandToKingdom}>Add</button>
            </div>
          </div>
        </div>
        <img src='kingdom.jpg' alt='' className='right' />
      </div>
    </div>
  );
}
