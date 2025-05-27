// 1. JavaScript Basics
console.log("Welcome to the Community Portal");
window.onload = () => alert("The page has fully loaded!");

// 2. Syntax, Data Types
const today = new Date();
let events = [
  { name: "Tech Conference", date: "2025-06-20", category: "Workshop", seats: 10, location: "Hall A" },
  { name: "Music Night", date: "2025-06-25", category: "Music", seats: 5, location: "Hall B" },
  { name: "Baking Workshop", date: "2025-05-10", category: "Workshop", seats: 0, location: "Hall C" }, // Full
  { name: "Past Event", date: "2025-04-01", category: "Music", seats: 5, location: "Hall D" } // Past
];

// 3. Conditionals, Loops, Error Handling
function displayEvents(filterFn = () => true) {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = "";
  const select = document.querySelector("form select[name='event']");
  select.innerHTML = `<option value="">Select Event</option>`;

  events.forEach((event, index) => {
    const eventDate = new Date(event.date);
    if (eventDate >= today && event.seats > 0 && filterFn(event)) {
      const card = document.createElement("div");
      card.className = "event-card";
      card.innerHTML = `
        <strong>${event.name}</strong><br />
        Date: ${event.date} | Category: ${event.category} | Seats: <span id="seats-${index}">${event.seats}</span><br />
        Location: ${event.location}<br />
        <button onclick="register(${index})">Register</button>
      `;
      container.appendChild(card);

      // 11. Forms: Populate dropdown
      const option = document.createElement("option");
      option.value = index;
      option.textContent = event.name;
      select.appendChild(option);
    }
  });
}

// 4. Functions, Closures, Higher-Order
function createCategoryCounter() {
  const counts = {};
  return function (category) {
    counts[category] = (counts[category] || 0) + 1;
    return counts[category];
  };
}
const countCategoryRegistration = createCategoryCounter();

// 5. Objects and Prototypes
function Event(name, date, category, seats) {
  this.name = name;
  this.date = date;
  this.category = category;
  this.seats = seats;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};

// 6. Arrays & Methods
events.push(new Event("Jazz Concert", "2025-07-05", "Music", 8));

const musicEvents = events.filter(e => e.category === "Music");
const displayCards = musicEvents.map(e => `🎵 ${e.name} - ${e.date}`);

// 7. DOM Manipulation
function register(index) {
  try {
    if (events[index].seats <= 0) throw new Error("No seats left");
    events[index].seats--;
    document.getElementById(`seats-${index}`).textContent = events[index].seats;
    alert(`Registered for ${events[index].name}`);
    countCategoryRegistration(events[index].category);
  } catch (err) {
    alert("Error: " + err.message);
  }
}

// 8. Event Handling
document.getElementById("categoryFilter").onchange = function () {
  const selected = this.value;
  displayEvents(event => !selected || event.category === selected);
};

document.getElementById("searchInput").addEventListener("keydown", function (e) {
  const keyword = e.target.value.toLowerCase();
  displayEvents(event => event.name.toLowerCase().includes(keyword));
});

// 9. Async JS & Fetch API
async function fetchMockEvents() {
  document.getElementById("eventsContainer").innerHTML = "Loading...";
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Mock fetch result:", data.slice(0, 3));
  } catch (err) {
    console.error("Fetch failed", err);
  }
}
fetchMockEvents();

// 10. Modern JS: Destructuring & Spread
const [firstEvent, ...rest] = events;
const clonedEvents = [...events];

// 11. Forms
document.getElementById("registrationForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const { name, email, event: eventIndex } = e.target.elements;

  if (!name.value || !email.value || !eventIndex.value) {
    document.getElementById("formMessage").textContent = "Please fill all fields.";
    return;
  }

  document.getElementById("formMessage").textContent = "";
  simulateSubmission({ name: name.value, email: email.value, event: events[eventIndex.value].name });
});

// 12. AJAX & Fetch (mock)
function simulateSubmission(data) {
  console.log("Submitting:", data);
  setTimeout(() => {
    alert(`Registered ${data.name} for ${data.event}`);
  }, 1000);
}

// 13. Debugging
function debugRegistration() {
  console.log("Debugging registration process...");
  debugger;
}

// 14. jQuery & Frameworks
// (Assuming jQuery is loaded if needed)
try {
  if (window.$) {
    $("#registerBtn").click(() => alert("Registered via jQuery"));
    $(".event-card").fadeIn();
  }
} catch (e) {
  // Ignore if jQuery is not available
}

// Benefit of frameworks:
console.log("React or Vue simplifies state management and reactivity.");

displayEvents(); // Initial render
