# FetchAndroidInternTestApp

FetchAndroidInternTestApp is an Android application that retrieves and displays a list of items from an API in a user-friendly, grouped, and expandable format. The app filters out items with blank or null names, groups them by `listId`, and sorts each group by item ID. It also features a "Surprise" button that triggers a bottom sheet dialog with an animation.

## Features

- **Data Retrieval:**  
  Fetches JSON data from [https://fetch-hiring.s3.amazonaws.com/hiring.json](https://fetch-hiring.s3.amazonaws.com/hiring.json) using Volley.

- **Data Processing:**  
  Filters out items with empty or null names, groups items by `listId`, and sorts each group by item ID.

- **Expandable Groups:**  
  Displays grouped items in an expandable list. Tapping a group header expands or collapses the list of items within that group.

- **Modern UI:**  
  Utilizes Material Components such as MaterialToolbar, FloatingActionButton, ChipGroup, RecyclerView, and ConstraintLayout for a polished, modern interface.

- **Surprise Feature:**  
  A "Click for surprise" button opens a bottom sheet dialog with an animation (using Lottie) to thank donors.

## Technologies Used

- **Language:** Java  
- **Android SDK:** API level 24+  
- **Networking:** Volley  
- **UI Components:** Material Components (Toolbar, FAB, ChipGroup, RecyclerView, etc.)  
- **Animations:** Lottie  
- **Layout:** ConstraintLayout

### Prerequisites

- Android Studio 4.0 or higher
- An Android device or emulator running API level 24 or above
- Internet connection (required for fetching API data)

### Installation

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/FetchAndroidInternTestApp.git
