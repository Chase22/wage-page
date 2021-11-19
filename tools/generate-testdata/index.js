const Mockaroo = require('mockaroo');

const client = new Mockaroo.Client({
  apiKey: '47280df0' // see http://mockaroo.com/api/docs to get your api key
});

const companies = [
  {
    id: "93cdd7b6-aa85-403f-9d96-9c1b2217b3e4",
    name: "Schiller and Sons",
    city: "cologne"
  },
  {
    id: "e2d83098-b5d7-4397-99d9-d8bceda64de7",
    name: "Dach-Olson",
    city: "berlin"
  },
  {
    id: "4da310fb-8717-44d4-aff9-c3f66fbe2d8f",
    name: "Gerhold LLC",
    city: "cologne"
  }
]

const jobs = ["Software Developer", "Carpenter", "IT Administrator", "Driver"]

const field = (name, type) => {
  return {
    name,
    type
  }
}

let content = 'insert into users values\n';

client.generate({
  count: 10,
  format: 'json',
  header: true, // this is the default, set to false to remove the header row
  fields: [
    field('id', 'GUID'),
    field('name', 'Username'),
    field('first_name', 'First Name'),
    field('last_name', 'Last Name'),
    field('email', 'Email Address'),
    field('company_id', 'GUID')
  ]
}).then(function (records) {
  console.log(records)
  records.forEach((record) => {
    content += `('${record.id}', 0, '${record.name}', '${record.first_name}', '${record.last_name}', '${record.email}', current_timestamp, current_timestamp),\n`
  })
  content[content.lastIndexOf(",")] = ',';
  console.log(content)
});