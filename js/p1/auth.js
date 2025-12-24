import jwt from 'jsonwebtoken';

export const auth = async(req, res, next)=>{
    const token = req.header('Authorization');
    if (!token) {
        return res.status(401).json({message: 'No token'});
    }
    const tokenParts = token.split(' ');
    const acturalToken = tokenParts[1];
    try {
        const decoded = jwt.verify(acturalToken, 'SECRET');
        req.user = decoded;
        next();
    } catch(error) {
        console.error(error);
        res.status(401).json({message:'token is not valid'
        })
    }
}