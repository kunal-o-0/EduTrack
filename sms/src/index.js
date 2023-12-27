import React from 'react';
import ReactDOM from 'react-dom/client';
import Button from "@mui/material/Button";
import { Autocomplete,TextField } from '@mui/material';

const root = ReactDOM.createRoot(document.getElementById('root'));

const top100Films = [
  { label: 'Vertigo', year: 1958 },
  {
    label: 'Star Wars: Episode VI - Return of the Jedi',
    year: 1983,
  },
  { label: 'Reservoir Dogs', year: 1992 },
  { label: 'Braveheart', year: 1995 },
  { label: 'M', year: 1931 },
  { label: 'Requiem for a Dream', year: 2000 },
  { label: 'Amélie', year: 2001 },
  { label: 'A Clockwork Orange', year: 1971 },
  { label: 'Like Stars on Earth', year: 2007 },
  { label: 'Taxi Driver', year: 1976 },
  { label: 'Lawrence of Arabia', year: 1962 },
  { label: 'Double Indemnity', year: 1944 },
  {
    label: 'Eternal Sunshine of the Spotless Mind',
    year: 2004,
  }
];


root.render(
  <div>
    <h1>Hello World</h1>
    <Button variant="contained">Click Me</Button>
    <Autocomplete
  disablePortal
  
  options={top100Films}
  sx={{ width: 300 ,marginTop:2}}
  renderInput={(params) => <TextField {...params} label="Movie" />}
/>
  </div>
);