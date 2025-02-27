# FetchAndroidInternTestApp

FetchAndroidInternTestApp is an Android application that retrieves and displays a list of items from an API in a user-friendly, grouped, and expandable format. The app filters out items with blank or null names, groups them by `listId`, and sorts each group by item ID. It also features a "Surprise" button that triggers a bottom sheet dialog with an animation.

## Demo Video Link

https://drive.google.com/file/d/15IgvFiR4SdQsBBvN3oXEep2gCO9UJ4Ut/view?usp=sharing

## Features

- **Splash Screen:**  
  For a smooth welcome to the app, along with a welcome coin burst animation using Lottie.

- **Data Retrieval:**  
  Fetches JSON data from [https://fetch-hiring.s3.amazonaws.com/hiring.json](https://fetch-hiring.s3.amazonaws.com/hiring.json) using Volley.

- **Data Processing:**  
  Filters out items with empty or null names, groups items by `listId`, and sorts each group by item ID.

- **Expandable Groups:**  
  Displays grouped items in an expandable list. Tapping a group header expands or collapses the list of items within that group.

- **Modern UI:**  
  Utilizes Material Components such as MaterialToolbar, FloatingActionButton, ChipGroup, RecyclerView, and ConstraintLayout for a polished, modern interface. Taking inspiration the "Fetch" colors.

- **Addition Feature:**  
  A "Floating Fetch Icon" button opens a bottom sheet dialog with an animation (using Lottie) to thank you for the opportunity.

- **Dark Mode:**  
  Supports Dark Mode as well as Light Mode.

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

2. **Open in Android Studio:**  
   - Open Android Studio and select **"Open an existing Android Studio project"**.  
   - Navigate to the cloned repository and open it.

3. **Sync and Build:**  
   - Allow Gradle to sync and build the project.

4. **Run the App:**  
   - Connect your device or start an emulator.  
   - Click the **Run** button in Android Studio.

## Usage

1. **Fetching Data:**  
   - Tap the **Fetch** button to retrieve data from the API.  
   - The app will filter out items with blank or null names, group them by `listId`, sort each group by item ID, and display the grouped data.

2. **Expanding Groups:**  
   - Tap on a group header to expand or collapse that group.  
   - When expanded, the group's items are displayed (for example, as chips).

3. **Floating Button Feature:**  
   - Tap the **Floating Fetch Icon** button to open a bottom sheet dialog featuring an animation that thanks you.

## Code Overview

1. **MainActivity.java:**  
   - Initializes UI components (RecyclerView, Fetch button, Floating button).  
   - Uses Volley to fetch data from the API when the Fetch button is pressed.  
   - Processes the JSON response by filtering, grouping, and sorting items.  
   - Updates the RecyclerView adapter with the grouped data.

2. **GroupAdapter.java:**  
   - Custom RecyclerView adapter that manages the display of grouped items.

3. **Data Models:**  
   - **Item.java:** Represents an individual item with properties such as `id`, `listId`, and `name`.  
   - **Group.java:** Represents a group of items, including a boolean flag for tracking the expansion state.

4. **Layouts:**  
   - XML layout files under `res/layout` define the UI for the main activity and group items.

5. **Styles and Themes:**  
   - The app uses Material Components themes and custom styles (defined in `res/values/themes.xml` and `res/values/styles.xml`) to maintain a consistent look and feel, supports dark mode too.



