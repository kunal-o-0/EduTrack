// // src/App.js

// import React from 'react';
// import './App.css';
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
// import Footer from './Footer'
// const App = () => {
//   return (
//     <>
//     <center><h1 style={{color:"white"}}>
//         SMS Title
//         </h1></center>

//         <div className=" navbar">
//           <ul className="nav nav-tabs card-header-tabs">
//             <li className="nav-item">
//               <a className="nav-link active" aria-current="true" href="#">
//                 Home
//               </a>
//             </li>
//             <li className="nav-item">
//               <a className="nav-link" href="#">
//                 AboutUs
//               </a>
//             </li>
//             <li className="nav-item">
//               <a className="nav-link" href="#">
//                 ContactUs
//               </a>
//             </li>
//           </ul>
//         </div>
//     <div>
//       <div className="card text-center mt-5">
//         <div className="card-body">
//           <h5 className="card-title">Special title treatment</h5>
//           <p className="card-text">
//             With supporting text below as a natural lead-in to additional content.
//           </p>
//           <a href="#" className="btn btn-primary">
//             Go somewhere
//           </a>
//         </div>
//         {/* Additional Cards */}
//         <div className="card mt-3">
//           <div className="card-body">
//             <h5 className="card-title">Card 2</h5>
//             <p className="card-text">
//               Additional content for Card 2. You can add more details here.
//             </p>
//             <div className="float-right">
//               <img
//                 src="https://via.placeholder.com/150" // Replace with your image URL
//                 alt="Card 2 Image"
//                 className="img-fluid"
//               />
//             </div>
//           </div>
//         </div>

//         <div className="card mt-3">
//           <div className="card-body">
//             <h5 className="card-title">Card 3</h5>
//             <p className="card-text">
//               Additional content for Card 3. You can add more details here.
//             </p>
//             <div className="float-right">
//               <img
//                 src="https://via.placeholder.com/150" // Replace with your image URL
//                 alt="Card 3 Image"
//                 className="img-fluid"
//               />
//             </div>
//           </div>
//         </div>
//         <div className="card mt-3">
//           <div className="card-body">
//             <h5 className="card-title">Card 3</h5>
//             <p className="card-text">
//               Additional content for Card 3. You can add more details here.
//             </p>
//             <div className="d-flex justify-content-end">
//               <img
//                 src="https://via.placeholder.com/150" // Replace with your image URL
//                 alt="Card 3 Image"
//                 className="img-fluid"
//               />
//             </div>
//           </div>
//         </div>
//         <div className="card mt-3">
//           <div className="card-body">
//             <h5 className="card-title">Card 3</h5>
//             <p className="card-text">
//               Additional content for Card 3. You can add more details here.
//             </p>
//             <div className="float-right">
//               <img
//                 src="https://via.placeholder.com/150" // Replace with your image URL
//                 alt="Card 3 Image"
//                 className="img-fluid"
//               />
//             </div>
//           </div>
//         </div>
//         <Footer></Footer>
//       </div>

//     </div>
//     </>

//   );
// };

// export default App;


// src/App.js

import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import Home from './Home';
import AboutUs from './AboutUs';
import ContactUs from './ContactUs';
import Footer from './Footer';

const App = () => {
  return (
      <>
      <center><h1 style={{color:"white"}}>
        SMS Title
        </h1></center>
    <Router>
       

        <div className="navbar">
          <ul className="nav nav-tabs card-header-tabs">
            <li className="nav-item">
              <Link to="/" className="nav-link">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/about" className="nav-link">
                AboutUs
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/contact" className="nav-link">
                ContactUs
              </Link>
            </li>
          </ul>
        </div>

        <div>
          <Route exact path="/" component={Home} />
          <Route path="/about" component={AboutUs} />
          <Route path="/contact" component={ContactUs} />

          {/* Additional Cards */}
          <div className="card text-center mt-5">
            <div className="card-body">
              <h5 className="card-title">Special title treatment</h5>
              <p className="card-text">
                With supporting text below as a natural lead-in to additional content.
              </p>
              <a href="#" className="btn btn-primary">
                Go somewhere
              </a>
            </div>
            {/* Additional Cards */}
            <div className="card mt-3">
              <div className="card-body">
                <h5 className="card-title">Card 2</h5>
                <p className="card-text">
                  Additional content for Card 2. You can add more details here.
                </p>
                <div className="float-right">
                  <img
                    src="https://via.placeholder.com/150" 
                    alt="Card 2 Image"
                    className="img-fluid"
                  />
                </div>
              </div>
            </div>

            <div className="card mt-3">
              <div className="card-body">
                <h5 className="card-title">Card 3</h5>
                <p className="card-text">
                  Additional content for Card 3. You can add more details here.
                </p>
                <div className="float-right">
                  <img
                    src="https://via.placeholder.com/150"
                    alt="Card 3 Image"
                    className="img-fluid"
                  />
                </div>
              </div>
            </div>
            <div className="card mt-3">
              <div className="card-body">
                <h5 className="card-title">Card 3</h5>
                <p className="card-text">
                  Additional content for Card 3. You can add more details here.
                </p>
                <div className="d-flex justify-content-end">
                  <img
                    src="https://via.placeholder.com/150" 
                    alt="Card 3 Image"
                    className="img-fluid"
                  />
                </div>
              </div>
            </div>
            <div className="card mt-3">
              <div className="card-body">
                <h5 className="card-title">Card 3</h5>
                <p className="card-text">
                  Additional content for Card 3. You can add more details here.
                </p>
                <div className="float-right">
                  <img
                    src="https://via.placeholder.com/150" 
                    alt="Card 3 Image"
                    className="img-fluid"
                  />
                </div>
              </div>
            </div>
            <Footer></Footer>
          </div>

        </div>

    </Router >
        
      
      </>
  );
};

export default App;
