# Music Library Management System

A Java-based music library management system designed to organise and manage **artists, music tracks, albums, and compilation albums**.

The project demonstrates object-oriented programming, inheritance, Java collections, file handling, data relationships, sorting, and algorithmic problem solving.

---

## Overview

The Music Library Management System provides a structured way to represent and manage a collection of music.

The application allows users to work with:

- Artists and their band memberships
- Individual music tracks
- Albums and their tracks
- Compilation albums containing multiple artists
- Track ratings and play counts
- Music library collections
- Music backup across storage devices

The application reads music data from text files, converts the data into Java objects, performs operations on those objects, and writes results to an output file.

---

## Features

### Artist Management

- Store artist information
- Track band memberships
- Support artists belonging to multiple bands
- Retrieve and update artist details

### Music Track Management

Each music track can contain:

- Track title
- Main artist
- Guest artists
- Release date
- Track duration
- Rating
- File location
- File size
- Play count

The system also supports incrementing the play count when a track is played.

### Album Management

Albums contain collections of music tracks and provide functionality to:

- Retrieve album information
- Calculate total album duration
- Calculate average track rating
- Calculate total album size
- Access associated artist information

### Compilation Albums

Compilation albums extend the standard `Album` class using Java inheritance.

Unlike a standard album, a compilation album can contain music from multiple artists and maintains mappings between tracks and their original albums.

### Music Library Management

The central `MusicLibrary` class manages collections of tracks and albums.

It supports:

- Adding a single track
- Adding multiple tracks
- Adding albums
- Retrieving all tracks
- Retrieving all albums
- Finding tracks with the lowest ratings
- Backing up music across storage devices

### Music Backup

The project includes a storage backup feature based on the **Next Fit Bin Packing algorithm**.

Given the capacity of a storage device such as a CD or DVD, the system determines how many storage units are required to back up the music tracks.

---

## System Design

The application consists of six main Java classes:

| Class | Responsibility |
|------|----------------|
| `MainClass` | Application entry point, file processing and object creation |
| `Artist` | Stores artist information and band memberships |
| `MusicTrack` | Represents individual music tracks |
| `Album` | Represents albums containing multiple tracks |
| `MusicLibrary` | Manages the overall collection of tracks and albums |
| `CompilationAlbum` | Extends `Album` to support multiple artists and original album mappings |

---

## Object-Oriented Design

The project demonstrates several core Java and object-oriented programming concepts.

### Encapsulation

Class variables are kept private and accessed or modified through getter and setter methods.

### Inheritance

`CompilationAlbum` extends the `Album` class, allowing it to reuse album functionality while adding support for multiple artists and mappings to original albums.

### Object Composition

Objects are connected to represent relationships within the music library.

For example:

```text
Artist
   │
   ├── MusicTrack
   │
   └── Album
          │
          └── MusicTrack

Album
   │
   └── CompilationAlbum

MusicLibrary
   │
   ├── Albums
   └── MusicTracks
```

---

## Data Handling

The project uses text files for input and output.

### Input Files

The application reads data from:

```text
artists.txt
music_tracks.txt
albums.txt
compilationAlbum.txt
```

These files contain IDs that are used to establish relationships between artists, tracks and albums.

### Output File

Program output is written to:

```text
myOutputs.txt
```

The input files are stored within the project's resources directory and accessed using relative file paths.

---

## Data Relationships

Unique IDs connect the different entities within the application.

For example:

```text
Artist ID
   │
   ├──── Music Track
   │
   └──── Album

Music Track ID
   │
   ├──── Album
   │
   └──── Compilation Album

Album ID
   │
   └──── Compilation Album
```

Java `HashMap` collections are used to map IDs to their corresponding objects.

The main application maintains mappings for:

```text
artistMap
musicMap
albumMap
```

This allows related objects to be retrieved efficiently while processing the input data.

---

## ⚙️ Key Functionality

Some of the main methods implemented in the project include:

### MusicTrack

```java
incrementPlayCount()
getAllArtists()
```

### Album

```java
getAlbumDuration()
getAvgRating()
getAlbumSize()
```

### MusicLibrary

```java
getAllAlbums()
getAllTracks()
addTrack()
addMultipleTracks()
addAlbums()
getTracksWithLowestRating()
backupMusicTracks()
```

### CompilationAlbum

```java
getMusicAndAlbumMap()
getAlbumArtistList()
setMusicAndAlbumMap()
setAlbumArtistList()
```

---

## Algorithms & Data Structures

The project makes use of several Java data structures and algorithmic techniques.

### Data Structures

- `ArrayList`
- `List`
- `HashMap`
- `Map`

### Algorithms

- Sorting tracks according to ratings
- Next Fit Bin Packing for music backup
- File parsing and object mapping
- Date parsing and validation

The use of `HashMap` enables IDs from the input files to be associated with their corresponding Java objects.

---

## Tech Stack

- **Java**
- **Object-Oriented Programming (OOP)**
- **Java Collections Framework**
- **Java I/O**
- **Eclipse IDE**
- **Text-file based data storage**

The project was originally developed and tested using **Eclipse IDE for Enterprise Java and Web Developers 4.29.0**.

---

## Project Structure

The exact directory structure may vary depending on the local Eclipse configuration, but the project follows the general structure:

```text
Music-Library/
│
├── src/
│   ├── MainClass.java
│   ├── Artist.java
│   ├── MusicTrack.java
│   ├── Album.java
│   ├── MusicLibrary.java
│   ├── CompilationAlbum.java
│   │
│   └── resources/
│       ├── artists.txt
│       ├── music_tracks.txt
│       ├── albums.txt
│       ├── compilationAlbum.txt
│       └── myOutputs.txt
│
├── doc/
│
└── README.md
```

> Update this section if your GitHub repository uses a different folder structure.

---

## Running the Project

### Using Eclipse

1. Clone the repository:

```bash
git clone <your-repository-url>
```

2. Open **Eclipse IDE**.

3. Import the project into your workspace.

4. Ensure that the resource text files are available under the appropriate source/resources directory.

5. Locate `MainClass.java`.

6. Run the application using:

```text
Run As → Java Application
```

`MainClass` contains the application's `static main` method and acts as the driver for the project.

---

## Testing

The project uses sample data to exercise the implemented methods and test expected and edge-case behaviour.

The driver class creates the required objects from the input files and calls methods across the application's classes.

Methods that produce output write their results to:

```text
myOutputs.txt
```

This provides a record that can be inspected to verify the behaviour of the application.

---

## Key Skills Demonstrated

This project demonstrates practical experience with:

- Java programming
- Object-Oriented Programming
- Encapsulation
- Inheritance
- Constructors
- Getter and setter methods
- Object composition
- Java Collections
- `ArrayList`
- `HashMap`
- File I/O
- Exception handling
- Data parsing
- Sorting
- Algorithm implementation
- Data modelling
- Testing and edge-case handling
- JavaDoc documentation

---

## Future Improvements

Possible extensions to the project include:

- Replace text-file storage with a relational database
- Add a graphical user interface
- Add search and filtering for artists, tracks and albums
- Introduce playlists
- Add persistent play-history tracking
- Add unit tests using JUnit
- Improve input validation and exception handling
- Add Maven or Gradle for dependency and build management
- Expose music library functionality through a REST API
- Add a web-based frontend

---

## Author

**Aditi Jain**

Interested in building at the intersection of **software engineering, data, artificial intelligence, analytics and research**.
