import React from 'react';
import PropTypes from 'prop-types';
import Navbar from '../navigation/Navbar';
import Wallpaper from '../../assets/homepageWallpaper.png'


const HomePage = () => {
    return (
        <>
            <Navbar />
            <img src={Wallpaper} style={{width: "100%"}}/>
        </>
    );
};

export default HomePage;