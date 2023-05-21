

## 最低功能：
- [x] you will have to ensure that access to
  shared resources is properly handled and that simultaneous actions lead to a
  reasonable state.
- [x] a single central one that manages all the system state.
- [x] If you use RMI, then you need to design your remote interface(s) and servants
- [x] Multiple users can draw on a shared interactive canvas.
- [x] Your system will support a single whiteboard that is shared between all
  of the clients.
- [x] Shape: Shapes: at least your white board should support for line, circle, oval, and rectangle.
- [x] Text inputting– allow user to type text anywhere inside the white board.
- [x] User should be able choose their favourite colour to draw the above features. At least 16
  colours should be available.
- [x]  Chat Window (text based): To allow users to
  communicate with each other by typing a text.
- [x] A “File” menu with new, open, save, saveAs and
  close should be provided (only the manager can
  control this)
- [x] Allow the manager to kick out a certain
  peer/user
- [x] Users must provide a username when joining the whiteboard. There should
  be a way of uniquely identifying users, either by enforcing unique usernames
  or automatically generating a unique identifier and associating it with each
  username.
- [x] All the users should see the same image of the whiteboard and should have
  the privilege of doing all the drawing operations.
- [x] When displaying a whiteboard, the client user interface should show the
  usernames of other users who are currently editing the same whiteboard.
- [x] Clients may connect and disconnect at any time. When a new client joins the
  system, the client should obtain the current state of the whiteboard so that
  the same objects are always displayed to every active client.
- [x] Only the manager of the whiteboard should be allowed to create a new
  whiteboard, open a previously saved one, save the current one, and close
  the application.
- [x] Users should be able to work on a drawing together in real time, without
  appreciable delays between making and observing edits.
- [x] The first user creates a whiteboard and becomes the whiteboard’s
  manager
- [x] Other users can ask to join the whiteboard application any time by
  inputting server’s IP address and port number
- [x] A notification will be delivered to the manager if any peer wants to
  join. The peer can join in only after the manager approves
- [x] An online peer list should be maintained and displayed
- [x] Online peers can choose to leave whenever they want. The manager
  can kick someone out at any time.
- [x] When the manager quits, the application will be terminated. All the
  peers will get a message notifying them.
- 
