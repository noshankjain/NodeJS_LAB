const express = require('express');
const app = express();

app.get('/ExpressBasicExample', (req, res) => {
  const param1 = req.query.param1;

  res.set('Content-Type', 'text/html');

  if (param1 === undefined) {
    res.status(200).send('<b><i>param1 is missing in the request.</i></b>');
  } else if (param1.length < 5) {
    res.status(200).send(`<b><i>param1 is short (${param1.length} characters). Needs to be 5 or more.</i></b>`);
  } else if (param1.length >= 5) {
    res.status(200).send(`<b><i>param1 is long (${param1.length} characters). Looks good!</i></b>`);
  }
});

// Catch all other unsupported routes
app.use((req, res) => {
  res.status(400).send('<b><i>Unsupported request from client</i></b>');
});

const PORT = 3001;
app.listen(PORT, () => {
  console.log(`Express server running at http://localhost:${PORT}`);
});
