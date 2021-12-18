import React,{useEffect, useState} from 'react';
import AuthService from '../../service/AuthService';
import DoctorService from '../../service/DoctorService';
import Navbar from '../navigation/Navbar';
import Button from '@mui/material/Button';
import AddBed from './AddBed';
import AddPatient from './AddPatient';

const Dashboard = () => {
    const [user, setUser] = useState([]);
    const [renderPage, setRenderPage] = useState(null);

    useEffect(() => {
        DoctorService.getDoctor(AuthService.getCurrentUser().id).then(res => {
            setUser(res.data);
        })
    },[]);

    console.log(user);

    const changeRender = (content) => {
        setRenderPage(content);
    }

    return (
        <>
            <Navbar />
            <div className="dashboard-container">
                <div className="dashboard-section b-right f-1">
                    <p style={{fontSize:"24px", fontWeight:"550", marginBottom:"20px"}}>{user.name}</p>
                    <p style={{fontSize:"20px", fontWeight:"500",marginBottom:"10px"}}>Gender: {user.sex}</p>
                    {/* <p style={{fontSize:"20px", fontWeight:"500",marginBottom:"10px"}}>Start date: {""+ user.startDate[0]+ "-" + user.startDate[1] + "-" + user.startDate[2]}</p> */}
                    <p style={{fontSize:"20px", fontWeight:"500",marginBottom:"10px"}}>Age: {user.age}</p>
                    <p style={{fontSize:"20px", fontWeight:"500",marginBottom:"10px"}}>Phone: {user.phoneNumber}</p>
                </div>
                <div className="dashboard-section d-flex collumn align-center f-3">
                    {renderPage}
                </div>
                <div className="dashboard-section d-flex collumn f-1 b-left">
                    <Button  style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"30px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"10px"}} onClick = {() => changeRender(<AddBed departmentId = {user.department.id} />)}>Add Bed</Button>        
                    <Button  style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"30px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"10px"}} onClick = {() => changeRender(<AddPatient departmentId = {user.department.id} />)}>Add Patient</Button>        
                    <Button  style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"30px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"10px"}}>Add Room</Button>        
                </div>
            </div>
            
        </>
    );
};

export default Dashboard;