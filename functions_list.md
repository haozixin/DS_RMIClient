1. Shapes: at least your white board should support for line, circle, oval, and rectangle.
2. Text inputting– allow user to type text anywhere inside the white board.
3. User should be able choose their favourite colour to draw the above features. At least 16 colours should be available.

4. 窗口组件随着窗口大小的变化而变化，保证窗口组件的可见性。
5. 自由画笔
6. 选择各种颜色（用的自带组件）
7. 图形选择快捷键
8. 异常中断，会告诉服务器，并更新用户列表
9. 如果是第一次保存，点击save时会发出提示并自动调用saveAs进行储存，下次再点击save时，对于保存过第一次的画板会保存到对应的文件中
10. 每次创建新画板会fileSavePath会被重置为null, 意味着点击save时，会调用saveAs，而不是保存到之前的文件中 （画流程图）


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
- [ ] A “File” menu with new, open, save, saveAs and
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
- [ ] Clients may connect and disconnect at any time. When a new client joins the
  system, the client should obtain the current state of the whiteboard so that
  the same objects are always displayed to every active client.
- [ ] Only the manager of the whiteboard should be allowed to create a new
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
