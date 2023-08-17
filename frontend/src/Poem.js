import { useState } from 'react';
import { RiseLoader } from 'react-spinners';

export default function Poem() {
  const [prompt, setPrompt] = useState('');
  const [poem, setPoem] = useState('');
  const [loading, setLoading] = useState(false);

  const generatePoem = () => {
    const get = async () => {
      try {
        setLoading(true);
        const response = await fetch(`http://localhost:8080/poem/${prompt}`);
        const data = await response.json();
        console.log(data);
        let text = data.choices[0].message.content;
        text = text.replaceAll('\n', '<br/>');
        setLoading(false);
        setPoem(text);
      } catch (err) {
        alert(err);
      }
    };
    get();
  };

  return (
    <div>
      <div className='flex'>
        <div>
          <h1>Generate poem about GOT characters</h1>
          <div>
            <input
              type='text'
              value={prompt}
              onChange={(e) => setPrompt(e.target.value)}
              placeholder='Enter your description here'
              className='description'
            />
            <button onClick={generatePoem}>Generate</button>
          </div>
          {loading ? (
            <div>
              <div className='spinners'>
                <RiseLoader color='#DE0201' />
                <RiseLoader color='#FA8907' />
                <RiseLoader color='#FBEB04' />
              </div>
              <div className='spinners'>
                <RiseLoader color='#028127' />
                <RiseLoader color='#004DF9' />
                <RiseLoader color='#750480' />
              </div>
            </div>
          ) : (
            <div dangerouslySetInnerHTML={{ __html: poem }} className='poem'></div>
          )}
        </div>
        <img src='horses.jpg' alt='' className='right' />
      </div>
    </div>
  );
}
