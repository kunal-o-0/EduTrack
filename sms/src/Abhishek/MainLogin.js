import * as React from 'react';
// import { useHistory } from 'react-router-dom';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import LinkMUI from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import "./App.css";
import { Link,Route,BrowserRouter,Switch } from 'react-router-dom';
import StudentLogin from './StudentLogin';

function Copyright(props) {
  return (
    <div id='footer'> <Typography  variant="body2" color="text.secondary" align="center" {...props}>
     
    {'Copyright © '}
    <LinkMUI color="inherit" href="https://mui.com/">
      EduSync
    </LinkMUI>{' '}
    {new Date().getFullYear()}
    {'.'}
  </Typography></div>
   
  );
}

// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();

export default function MainLogin() {
  // const handleSubmit = (event) => {
  //   event.preventDefault();
  //   console.log(event);
  //   const data = new FormData(event);
  //   console.log({
  //     email: data.get('email'),
  //     password: data.get('password'),
  //   });
  // };

  
  return (

    <ThemeProvider theme={defaultTheme}>
      <BrowserRouter>
      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: 'url(https://source.unsplash.com/random?wallpapers)',
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) =>
              t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
            backgroundSize: 'cover',
            backgroundPosition: 'center',
          }}
        />
        
        <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Continue As..
            </Typography>
            <Box component="form" noValidate sx={{ mt: 1 }}>
           
      <Link to="/StudentLogin">
            <Button
                type="submit"
                id='studentbtn'
                className='btn'
              
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Student
                
              </Button>
      </Link>
             
              <Button
                type="submit"
                id='facultybtn'
                className='btn'
               
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Faculty
              </Button>
              
             
              <Button
                type="submit"
                id='staffbtn'
                className='btn'
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Staff
              </Button>
              <Button
                type="submit"
                id='headbtn'
                className='btn'
                fullWidth
                variant="contained"
               
                sx={{ mt: 3, mb: 2 }}
              >
                Head
              </Button>
        
              <Grid container>
               
              </Grid>
              <Copyright sx={{ mt: 5 }} />
            </Box>
          </Box>
        </Grid>
      </Grid>
      
      <Switch>
        <Route  path="/StudentLogin" exact component={StudentLogin}/>
      </Switch>
      </BrowserRouter>
    </ThemeProvider>
  );
}