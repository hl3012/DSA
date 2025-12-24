import express from 'express';
import bcript from 'bcrypt';
import jwt from 'jsonwebtoken';
import {auth} from './auth.js'

const app = express();
const PORT = 3000;

app.use(express.json());

let users = [];

app.post('/api/auth/signup', async (req, res) => {
    try {
        const {name, email, password} = req.body;
        if (!name ||!email||!password) {
            return res.status(400).json({message: 'Please enter all fields'});
        }

        const existingUser = users.find(user=>user.email===email);
        if (existingUser) {
            return res.status(400).json({message: 'User already exist'});
        }
        const salt = 10;
        const hashedPassword = await bcript.hash(password, salt);
        const newUser = {
            id: users.length+1,
            name,
            email,
            password: hashedPassword
        };
        users.push(newUser);
        return res.status(201).json({
            user: {
                if: newUser.id,
                name: newUser.name,
                email: newUser.email
            }
        })
    } catch (error) {
        console.error(error);
        res.status(500).json({message:'server error'});
    }
})

app.post('/api/auth/login', async (req, res)=>{
    try {
        const {email, password} = req. body;
        if(!email||!password) {
            res.status(400).json({message: 'invalid input'});
        }
        const user = users.find(user=>user.email === email);
        if (!user) {
            return res.status(400).json({message: 'invalid credential'});
        }
        const idPasswordValid = await bcript.compare(password, user.password);
        if (!idPasswordValid) {
            return res.status(400).json({message: 'invalid password'});
        }
        const token = jwt.sign(
            {id: user.id},
            'SECRET',
            {expiresIn: '1h'}
        )
        res.json({
            message: 'login successfully',
            token,
            user: {
                id: user.id,
                name: user.name,
                email: user.email
            }
        })


    } catch (error) {
        console.error(error);
        res.status(500).json({message: 'server fails'});
    }
})

app.get('/api/auth/me', auth, (req, res) => {
    const user = users.find(u => u.id === req.user.id);
  
    if (!user) {
      return res.status(404).json({ message: 'User not found' });
    }

    res.json({
      id: user.id,
      name: user.name,
      email: user.email
    });
  });

  app.delete('/api/users/:id', auth, async (req, res) => {
    try {
      const userIdToDelete = parseInt(req.params.id); 
  
      const currentUserId = req.user.id;
  
      const userIndex = users.findIndex(user => user.id === userIdToDelete);
  

      if (userIndex === -1) {
        return res.status(404).json({ message: 'User not found' });
      }
  
      if (currentUserId !== userIdToDelete) {
        return res.status(403).json({ 
          message: 'Access denied. You can only delete your own account.' 
        });
      }
  
      const deletedUser = users.splice(userIndex, 1)[0];
  
      res.json({ 
        message: `User with email ${deletedUser.email} has been deleted successfully.` 
      });
  
    } catch (error) {
      console.error(error);
      res.status(500).json({ message: 'Server error during deletion' });
    }
  });

  app.patch('/api/users/:id', auth, async (req, res) => {
    try {

      const userIdToUpdate = parseInt(req.params.id);
      const updates = req.body; 
  
      const currentUserId = req.user.id;
  

      if (currentUserId !== userIdToUpdate) {
        return res.status(403).json({ message: 'Access denied. You can only update your own profile.' });
      }
  
      const userToUpdate = users.find(user => user.id === userIdToUpdate);
      if (!userToUpdate) {
        return res.status(404).json({ message: 'User not found' });
      }
  
      const allowedUpdates = ['name', 'email']; 
      const requestedUpdates = Object.keys(updates);
      const isValidOperation = requestedUpdates.every(field => allowedUpdates.includes(field));
  
      if (!isValidOperation) {
        return res.status(400).json({ message: 'Invalid updates! Only name and email can be updated.' });
      }
  
      if (updates.email) {
        const emailExists = users.some(user => user.email === updates.email && user.id !== userIdToUpdate);
        if (emailExists) {
          return res.status(400).json({ message: 'Email already in use by another account.' });
        }
      }
  
      Object.keys(updates).forEach(key => {
        userToUpdate[key] = updates[key];
      });
  
      res.json({
        message: 'User updated successfully',
        user: {
          id: userToUpdate.id,
          name: userToUpdate.name,
          email: userToUpdate.email
        }
      });
  
    } catch (error) {
      console.error(error);
      res.status(500).json({ message: 'Server error during update' });
    }
  });

app.listen(PORT, ()=>{
    console.log(`Server is running on http://localhost:${PORT}`);
})