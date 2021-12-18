import React from 'react';

const RoomCard = ({room, getRoomId}) => {

    const handleRoomClick = () => {
        getRoomId(room.id);
    };

    return (
        <div className="room-card" onClick={handleRoomClick}>
            <p>{room.name}</p>
        </div>
    );
};

export default RoomCard;