import React from 'react'
import DoctorService from '../../service/DoctorService';
import Footer from '../navigation/Footer';
import Navbar from '../navigation/Navbar';
import ProfilePhoto from '../../assets/ProfilePhoto.png'

import './UserProfile.css';

export default function UserProfile() {

    const [doctor, setDoctor] = React.useState([]);

    let doctorId = JSON.parse(window.localStorage.getItem('user'));
    console.log(doctorId);
    doctorId = doctorId.id;
    console.log(doctorId);



    React.useEffect(() => {
        DoctorService.getDoctor(doctorId).then(res => {
            setDoctor(res.data);
        });
    } , []);

    console.log(doctor);

    return (
        <div>
            <Navbar/>
            <div className='doctor-details-div'>
                <div>
                    <ul style={{listStyleType: "none"}}>
                        <li><img src={ProfilePhoto} style={{width: "150px", height: "150px"}} className="profile-photo"/></li>
                        <li>Name: {doctor.name}</li>
                        <li>Username: {doctor.username}</li>
                        <li>Age: {doctor.age}</li>
                        <li>Gender: {doctor.sex}</li>
                        <li>PhoneNumber: {doctor.phoneNumber}</li>
                        <li>Start Date: {doctor.startDate}</li>
                    </ul>
                </div>
            </div>
            {/* <Footer/> */}
        </div>
    )
}
