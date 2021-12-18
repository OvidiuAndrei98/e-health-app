import React, {useEffect} from 'react'
import { NavLink } from 'react-router-dom'
import ProfilePhoto from '../../assets/ProfilePhoto.png'
import Settings from '../../assets/Settings-popUp.png'
import { useLocation } from 'react-router-dom';
import AuthService from '../../service/AuthService';


const Navbar = () => {
    const [popUp, setPopUp] = React.useState(false);
    const [show, setShow] = React.useState({display: "none"});
    const location = useLocation();
    const { pathname } = location;
    const splitLocation = pathname.split("/");

    const handlePopup = () => {
        setPopUp(!popUp);
    }

    const handleShow = () => {
        setShow({display: "flex"});
        setPopUp(false);
    }

    const handleShowLeave = () => {
        setShow({display: "none"});
    }


    const goToSettings = () => {
        window.location.href = '/user/my-profile';
    }


    const logout = () => {
        window.location.href = '/';
        AuthService.logout();
    }

    return (
        <div className="nav-container">
            <div className="nav">
                <div className="logo"><NavLink to="/">EasyMed</NavLink></div>
                {AuthService.getCurrentUser() ? (
                <ul>
                            <li className={splitLocation[1] === "departments" ? "active-link" : ""}><NavLink to="/departments">Departments</NavLink></li>,
                            <li><NavLink to="/dashboard">Dashboard</NavLink></li>,
                            <li><NavLink to="/user/messages">Messages</NavLink></li>,
                            <li><img src={ProfilePhoto} className="profile-photo" onClick={handlePopup} />
                            {popUp ? (
                        <ul className="profile-dropdown">   
                            <li><a href='/profile' style={{textDecoration: "none"}} className="profile-pop-up"><img src={ProfilePhoto} className="profile-photo-pop-up" />Andrei Penica</a></li>
                            <li><div className="profile-pop-up" ><img src={Settings}/>Settings</div></li>    
                            <li><div className="profile-pop-up" onClick={logout}><img src={Settings}/>Logout</div></li>
                        </ul>) : ("")}</li>
                </ul>
                ) : (<ul>
                    <li>How it works</li>
                    <li><NavLink to="/register-doctors">Doctors</NavLink></li>
                    <li><NavLink to="/register-hospital">Hospitals</NavLink></li>
                    <li><NavLink to="/login">Login</NavLink></li>
                </ul>)}
                
            </div>
        </div>
    )
}

export default Navbar