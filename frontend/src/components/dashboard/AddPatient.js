import React,{useEffect} from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { makeStyles } from '@mui/styles';
import RoomService from '../../service/RoomService';
import Button from '@mui/material/Button';
import BedService from '../../service/BedService';
import BedImage from '../../assets/Bed.png'    
import Bed from '../departments/Bed';


const AddPatient = ({departmentId}) => {
    const [roomId, setRoomId] = React.useState(null);
    const [rooms, setRooms] = React.useState([]);
    const [beds, setBeds] = React.useState([]);

    useEffect(() => {
        RoomService.getAllRoomsForDepartment(departmentId).then(res => {
            setRooms(res.data);
        });
    } , []);

    const useStyles = makeStyles((theme) => ({
        root: {
            height: 50,
              "& .MuiInputLabel-root.Mui-focused": {
                color: "#798BF2"
              },
              "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
                borderColor: "#798BF2"
              }
          },
      }));
    
      const classes = useStyles();

      const handleSelect = (event) => {
            setRoomId(event.target.value);
            BedService.getAllBedsForRoom(roomId).then(res => {
                setBeds(res.data);
            });
      }

    //   const AddPatient = () => {
    //     BedService.addBed(roomId).then(res => {
    //         console.log(res);
    //     });
    //   }

    return (
        <>
        <div className="center-container">
            <img src={BedImage} />
            <div className="filter-container">
                <FormControl variant="outlined" sx={{ minWidth: "100%" }}>
                    <TextField
                        className={classes.root}
                        size="small"
                        variant="outlined"
                        labelId="rooms"
                        id="rooms"
                        onChange={handleSelect}
                        label="Rooms"
                        select
                    >
                        <MenuItem value="undefined">
                        <em>None</em>
                        </MenuItem>
                        {rooms.map(room => (
                            <MenuItem key={room.id} value={room.id}>{room.name}</MenuItem>
                        ))}
                    </TextField>
                </FormControl>
            </div>
                <div className="d-flex">
                {beds.map(bed => (
                    <div className="d-flex collumn aling-center">
                    <img src={BedImage} />
                    <p>{bed.id}</p>
                    </div>
                ))}
            </div>
            <Button  style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"30px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"10px"}}>Add Bed</Button>        
        </div>
            
        </>
    );
};

export default AddPatient;