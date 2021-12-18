import React from 'react';
import Navbar from '../navigation/Navbar';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { makeStyles } from '@mui/styles';
import {useForm} from 'react-hook-form';
import AuthService from '../../service/AuthService';
import { useNavigate } from "react-router";


const Login = () => {
const { register, handleSubmit, formState: {errors} } = useForm();
const navigate = useNavigate();


    const useStyles = makeStyles((theme) => ({
        root: {
            height: 50,
              "& .MuiInputLabel-root.Mui-focused": {
                color: "#798BF2"
              },
              "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
                borderColor: "#798BF2",
              },
              "& .MuiInputBase-root": {
                height:"50px",
              }
          },
      }));
    
      const classes = useStyles();
    return (
        <>
            <Navbar />
            <h1 style={{marginLeft:"36%",marginTop:"10%", position:"absolute",fontSize:"90px",color:"#041159"}}>EASYMED</h1>
            <form noValidate onSubmit={
                        handleSubmit((data) => {
                            AuthService.login(data).then(res => {
                                navigate("/departments");
                            });
                            }
                        )
                        }>
            <div className="login-container">
                <h1>Login</h1>
            <TextField className={classes.root} id="username"  label="Username" variant="outlined" size="small" sx={{ minWidth: "50%" }}
            {...register("username", {required: true})}/>
             <TextField type="password" className={classes.root} id="password" label="Password" variant="outlined" size="small" sx={{ minWidth: "50%" }}
            {...register("password", {required: true})}/>
            <Button type="submit" style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"20px 40px", height:"0", marginTop:"20px", float:"right", marginBottom:"0"}}>Login</Button> 
            <p>Don't have an account?Register</p>       
            </div>
            </form> 
        </>
    );
};

export default Login;