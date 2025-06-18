# Bookmarks

Since version 1.12.12, Freeplane supports bookmarks that help you organize and jump to important parts of your mind map.

## 🎯 Purpose

Bookmarks combine the functionality of both **sheets** and traditional **bookmarks** by letting you jump to specific sections of the map and optionally isolate them as a temporary root. They are especially useful for navigating large maps.

---

## 🛠️ How to Create a Bookmark

You can bookmark a node in two ways:

**From the context menu:**

1. Right-click on the node
2. Select *Bookmark node*
3. Enter a name and optionally check *Opens as root*
4. Click *OK*

**From the main menu:**

* Use *Navigate → Bookmark node* when a node is selected

---

## 📂 Using and Managing Bookmarks

Bookmarks appear as buttons in the bookmark bar (if visible).

**Clicking a bookmark:**

* Navigates to the node
* Opens it as visible root if *Opens as root* is set

**Right-clicking a bookmark opens a popup menu:**

* *Go to node* – select the node in context
* *Open as root* – open the node as temporary root
* *Delete* – remove the bookmark
* *Rename* – change its label
* *Opens as root* – toggle default opening mode

💡 The popup menu allows manual selection of the opening mode

---

## 🧭 Display and Interaction

* Bookmarks are saved with the map and always reference nodes from the same file
* The bookmark bar can be toggled via:
  – *View → Controls → Bookmarks*
  – or map background right-click → *Controls → Bookmarks*
* You can reorder bookmarks via drag and drop
* Tooltips show the content of the bookmarked node

---

## 🚫 Filtered Nodes and Access Limitations

When filters are active:

* 🙈 If the bookmarked node is hidden by a filter, its button is disabled and cannot be clicked
* 🧩 However, the bookmark popup menu still works:
  – You can right-click the disabled button and use *Go to node* or *Open as root*
