import React,{useEffect} from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { makeStyles } from '@mui/styles';
import RoomService from '../../service/RoomService';
import Button from '@mui/material/Button';
import BedService from '../../service/BedService';
import BedImage from '../../assets/Bed.png'    
import Patient from '../../assets/Fever.png'   
import Bed from '../departments/Bed';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';
import AddPatientModal from './AddPatientModal';


const AddPatient = ({departmentId}) => {
    const [roomId, setRoomId] = React.useState(null);
    const [rooms, setRooms] = React.useState([]);
    const [beds, setBeds] = React.useState([]);
    const [open, setOpen] = React.useState(false);
    const [bed, setBed] = React.useState([]);

    const handleClose = () => setOpen(false);

    const handleOpenModal = (bed) => {
        setOpen(true);
        setBed(bed);
    }


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

      const style = {
        position: 'absolute',
        top: '10%',
        left: '31%',
        width: "40%",
        bgcolor: 'background.paper',
        outline: 'none',
        p: 4,
        borderRadius: "5px 5px 0 0",
        };

      const handleSelect = (event) => {
            setRoomId(event.target.value);
            BedService.getEmptyBedsForRoom(event.target.value).then(res => {
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
        <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
                >
                <Box sx={style}>
                    <AddPatientModal bed = {bed} />
                </Box>
            </Modal>
            <img src={Patient} />
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
                    <div className="d-flex collumn aling-center" onClick={() => handleOpenModal(bed)}>
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