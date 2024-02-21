import {
  Alert,
  Box,
  Button,
  MenuItem,
  TextField,
  Typography,
} from "@mui/material";
import Styles from "../assets/Style";
import { Link, useNavigate } from "react-router-dom";
import { useState } from "react";
import { createOrganizObj, getOrganization } from "../services/organization";
import { addStaff, createStaff } from "../services/staff";
import { HttpStatusCode } from "axios";

function Register() {
  const navigate = useNavigate();
  const [showAlert, setShowAlert] = useState(<></>);
  const [staff, setStaff] = useState(createStaff());
  const [selectedOrg, setSelectedOrg] = useState({ org_id: "", org_name: "" });
  const [orgList, setOrgList] = useState([createOrganizObj()]);
  const [retypedPassword, setRetypedPassword] = useState("");

  const loadOrganizationList = () => {
    getOrganization().then((result) => {
      setOrgList(result);
    });
  };

  const handleRegister = () => {
    if (retypedPassword === staff.password) {
      addStaff(staff)
        .then((result) => {
          if (result.status == HttpStatusCode.Created) {
            setShowAlert(
              <Alert
                variant="filled"
                severity="success"
                sx={{ width: "100%", position: "fixed" }}
              >
                Successfully Registered!
              </Alert>
            );
            setTimeout(() => {
              setShowAlert(<></>);
              navigate("/login-register");
            }, 3000);
          }
        })
        .catch(() => {
          setShowAlert(
            <Alert
              variant="filled"
              severity="error"
              sx={{
                width: "75%",
                position: "fixed",
                left: "50%",
                top: "0.5rem",
                transform: "translateX(-50%)",
              }}
            >
              Sorry, unable to register at this moment!
            </Alert>
          );
          setTimeout(() => {
            setShowAlert(<></>);
          }, 3000);
        });
    } else {
      alert("Password doesn't match");
    }
  };

  const handleReset = () => {
    setStaff(createStaff());
  };

  const handleInputChange = (event) => {
    switch (event.target.id) {
      case "first_name": {
        const newStaff = { ...staff };
        newStaff.first_name = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "middle_name": {
        const newStaff = { ...staff };
        newStaff.middle_name = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "last_name": {
        const newStaff = { ...staff };
        newStaff.last_name = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "mob_no": {
        const newStaff = { ...staff };
        newStaff.mob_no = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "address_line": {
        const newStaff = { ...staff };
        newStaff.address.address_line = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "city": {
        const newStaff = { ...staff };
        newStaff.address.city = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "state": {
        const newStaff = { ...staff };
        newStaff.address.state = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "country": {
        const newStaff = { ...staff };
        newStaff.address.country = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "pincode": {
        const newStaff = { ...staff };
        newStaff.address.pincode = parseInt(event.target.value);
        setStaff(newStaff);
        break;
      }
      case "qualification": {
        const newStaff = { ...staff };
        newStaff.qualification = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "category": {
        const newStaff = { ...staff };
        newStaff.category = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "org_id": {
        const newStaff = { ...staff };
        newStaff.org_id = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "email": {
        const newStaff = { ...staff };
        newStaff.email = event.target.value;
        setStaff(newStaff);
        break;
      }
      case "password": {
        const newStaff = { ...staff };
        newStaff.password = event.target.value;
        setStaff(newStaff);
        break;
      }
    }
  };

  return (
    <>
      {showAlert}
      <Box
        sx={{
          width: { xs: "100%", sm: "50%" },
          padding: "2rem",
          backgroundColor: Styles.colors.primary,
        }}
      >
        <Box
          sx={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            padding: "0.5rem",
          }}
        >
          <Typography
            sx={{
              fontSize: "2rem",
              fontWeight: "600",
              color: Styles.colors.secondary_dark,
            }}
          >
            Registration Form
          </Typography>

          <div style={{ display: "flex", width: "100%", marginTop: "1rem" }}>
            {/* First name */}
            <TextField
              id="first_name"
              label="First name"
              sx={{ width: "100%" }}
              value={staff.first_name}
              onChange={handleInputChange}
              required
            />
            {/* Middle name */}
            <TextField
              id="middle_name"
              label="Middle name"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.middle_name}
              onChange={handleInputChange}
              required
            />
            {/* Last name */}
            <TextField
              id="last_name"
              label="Last name"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.last_name}
              onChange={handleInputChange}
              required
            />
          </div>
          {/* Mobile number */}
          <TextField
            id="mob_no"
            label="Mobile number"
            sx={{ width: "100%", marginTop: "1rem" }}
            value={staff.mob_no}
            onChange={handleInputChange}
            type="number"
            required
          />
          {/* address  */}
          <div style={{ display: "flex", width: "100%", marginTop: "1rem" }}>
            {/* address line */}
            <TextField
              id="address_line"
              label="Address line"
              sx={{ width: "100%" }}
              value={staff.address.address_line}
              onChange={handleInputChange}
              maxRows="2"
              required
            />
            {/* city */}
            <TextField
              id="city"
              label="City"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.address.city}
              onChange={handleInputChange}
              required
            />
          </div>
          <div style={{ display: "flex", width: "100%", marginTop: "1rem" }}>
            {/* state */}
            <TextField
              id="state"
              label="State"
              sx={{ width: "100%" }}
              value={staff.address.state}
              onChange={handleInputChange}
              required
            />
            {/* country */}
            <TextField
              id="country"
              label="Country"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.address.country}
              onChange={handleInputChange}
              required
            />
            {/* pincode */}
            <TextField
              id="pincode"
              label="Pincode"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.address.pincode}
              onChange={handleInputChange}
              type="number"
              required
            />
          </div>
          <div style={{ width: "100%", display: "flex", marginTop: "1rem" }}>
            {/* qualification */}
            <TextField
              id="qualification"
              label="Qualification"
              sx={{ width: "100%" }}
              value={staff.qualification}
              onChange={handleInputChange}
              required
            />
            {/* category */}
            <TextField
              id="category"
              label="Category"
              sx={{ width: "100%", marginLeft: "1rem" }}
              value={staff.category}
              onChange={handleInputChange}
              required
            />
          </div>
          {/* selection of organization */}
          <TextField
            id="org_id"
            label="Organization"
            select
            onFocus={loadOrganizationList}
            value={selectedOrg.org_name}
            sx={{ width: "100%", marginTop: "1rem" }}
          >
            {orgList.map((item) => {
              return (
                <MenuItem
                  value={item.org_name}
                  key={item.org_id}
                  id={item.org_id}
                  onClick={(event) => {
                    //  setting current selected org
                    setSelectedOrg({
                      org_id: event.target.id,
                      org_name: event.target.innerText,
                    });
                    //  setting of org_id into staff object
                    const newStaff = { ...staff };
                    newStaff.org_id = parseInt(event.target.id);
                    setStaff(newStaff);
                  }}
                >
                  {item.org_name}
                </MenuItem>
              );
            })}
          </TextField>
          {/* email */}
          <TextField
            id="email"
            label="Email id"
            sx={{ width: "100%", marginTop: "1rem" }}
            value={staff.email}
            onChange={handleInputChange}
            required
          />
          {/* password */}
          <TextField
            id="password"
            label="Password"
            sx={{ width: "100%", marginTop: "1rem" }}
            value={staff.password}
            onChange={handleInputChange}
            type="password"
            required
          />
          {/* re-enter password */}
          <TextField
            label="Retype password"
            sx={{ width: "100%", marginTop: "1rem" }}
            value={retypedPassword}
            onChange={(event) => {
              setRetypedPassword(event.target.value);
            }}
            type="password"
            required
          />
          <Button
            size="large"
            sx={{
              backgroundColor: Styles.colors.secondary,
              color: Styles.colors.primary,
              fontWeight: "900",
              fontSize: "1.1rem",
              width: "100%",
              marginTop: "2rem",
              ":hover": { backgroundColor: Styles.colors.secondary_dark },
            }}
            onClick={handleRegister}
          >
            Register
          </Button>
          <Button
            size="large"
            variant="text"
            sx={{
              color: Styles.colors.secondary,
              fontWeight: "900",
              fontSize: "1.1rem",
              width: "100%",
            }}
            onClick={handleReset}
            disableRipple
          >
            Reset
          </Button>
          <div
            style={{
              textAlign: "center",
              width: "100%",
              fontSize: "1.1rem",
              marginTop: "0.5rem",
              color: Styles.colors.secondary_dark,
            }}
          >
            Already have account? Login{" "}
            <Link
              to="/login-register"
              style={{
                textDecoration: "none",
                color: Styles.colors.secondary,
                fontWeight: "900",
              }}
            >
              here
            </Link>
          </div>
        </Box>
      </Box>
    </>
  );
}

export default Register;
