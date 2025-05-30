# 🌐 Global Student Network Generator

A Java-based GUI application that helps international students build global social networks by simulating visual connections between student profiles. The system uses similarity scoring and dynamic GUI interaction to encourage meaningful profile matches.

---

## 🎯 Project Purpose

International students often struggle with integration and social isolation. This application addresses that by allowing students to:
- Create profiles with details like name, age, nationality, university, major, interests, and classes.
- Visualize their profiles on a world map.
- View their connection strength with other students based on shared attributes.

---

## 🖥️ Features

- 🌍 **Interactive World Map:** Shows student profiles as clickable pins.
- 🧮 **Connection Strength Bar:** Calculates and displays similarity scores using the `CompareConnections` class.
- 📝 **Form-Based Profile Builder:** Easy-to-use form panel to collect student data.
- 💾 **File I/O:** Student profiles are saved and loaded using the `FileManager` class for data persistence.
- 📚 **OOP Principles:** Uses encapsulation, inheritance, and polymorphism throughout.

---

## 📺 Video Demonstration

Watch the full project demo here:  
🎥 [YouTube Video](https://youtu.be/oZV9fMl1vlw?si=X1T8N4vMggpOIXc5)

---

## 📂 Project Structure

```
├── src/
│   ├── GUIwindows/                # Main windows like MainPage, NetworkWindow
│   ├── GUIpanels/                 # Panels: StudentForm, Map, UniversityDropdown
│   ├── UserFiles/                 # Logic classes: Student, Person, University, etc.
│   └── Main.java                  # Application entry point
├── assets/                        # Assets like map image
├── Report.pdf                     # Final project report with diagrams
├── Presentation.pptx              # In-class presentation slides
├── Project design version X.pdf   # Jasmine's early design drafts
├── UsersData.dat                  # Serialized student data
└── README.md                      # This file
```

---

## 💡 Screenshots

> 📌 Screenshots are available in the `Report.pdf` under Project Results.  
These include the main window, instructions page, form panel, and map panel with student pins.

---

## 📊 Diagrams

### UML Class Diagram

![UML Class Diagram](assets/uml.jpg)

> Outlines core class relationships and object structure, including how the GUI components interact with domain classes like `Student`, `University`, and utility classes like `FileManager` and `CompareConnections`.

---

### Flow Diagram

![Flow Diagram](assets/flow_diagram.jpg)

> Describes logical flow from user input through the GUI to backend processes, including how profiles are created, saved, and visualized on the map.

---

## 🧠 Technologies & Concepts

- Java Swing (JFrame, JPanel, JList, JComboBox, GridBagLayout, MouseListener)
- File I/O: `ObjectInputStream`, `ObjectOutputStream`
- Serialization of custom objects
- OOP: Class inheritance, encapsulation, method abstraction
- Git for version control and collaborative development

---

## 🔗 GitHub Repository

📁 [https://github.com/mikaisloyal/Global-Student-Network_Smulator-Jasmines-Branch](https://github.com/mikaisloyal/Global-Student-Network_Smulator-Jasmines-Branch)

---

## 🧑‍🤝‍🧑 Contributors

- [**Jasmine Tuiachieva**](https://github.com/mikaisloyal)  
- [**Rita Chen**](https://github.com/RXCHEN1)
- [**Aron Lin**](https://github.com/TRGGB2)  
- [**Htoo Naing**](https://github.com/pimpleEater)  

---

## ✅ Status

🎓 **Completed as a final exam project**  
