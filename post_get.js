const express = require('express');
const app = express();
app.use(express.json()); // Middleware to parse JSON request bodies

let students = []; // In-memory "database"
let nextId = 1;     // Auto-incrementing ID

// Create a new student
app.post('/students', (req, res) => {
  const { name, age } = req.body;
  if (!name || !age) {
    return res.status(400).json({ error: 'Name and age are required.' });
  }

  const student = { id: nextId++, name, age };
  students.push(student);
  res.status(201).json(student);
});

// Get all students
app.get('/students', (req, res) => {
  res.json(students);
});

// Get a single student by ID
app.get('/students/:id', (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (!student) return res.status(404).json({ error: 'Student not found.' });
  res.json(student);
});

// Update a student by ID
app.put('/students/:id', (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (!student) return res.status(404).json({ error: 'Student not found.' });

  const { name, age } = req.body;
  if (name) student.name = name;
  if (age) student.age = age;

  res.json(student);
});

// Delete a student by ID
app.delete('/students/:id', (req, res) => {
  const index = students.findIndex(s => s.id === parseInt(req.params.id));
  if (index === -1) return res.status(404).json({ error: 'Student not found.' });

  const removed = students.splice(index, 1);
  res.json({ message: 'Student deleted.', student: removed[0] });
});

// Fallback for undefined routes
app.use((req, res) => {
  res.status(404).json({ error: 'Route not found.' });
});

// Start the server
const PORT = 3002;
app.listen(PORT, () => {
  console.log(`Student CRUD API is running at http://localhost:${PORT}`);
});
