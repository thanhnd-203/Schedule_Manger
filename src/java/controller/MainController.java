package controller;

import dao.DiaryEntryDAO;
import dao.UserDAO;
import model.DiaryEntryDTO;
import model.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainController extends HttpServlet {

    private static final String LOGIN_PAGE = "Login.jsp";
    private static final String REGISTER_PAGE = "Register.jsp";
    private static final String DIARY_LIST = "DiaryList.jsp";
    private static final String CREATE_DIARY = "CreateDiary.jsp";
    private static final String VIEW_DIARY = "ViewDiary.jsp";
    private static final String EDIT_DIARY = "EditDiary.jsp";
    private static final String DONE_LIST = "doneDiaryList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String url = LOGIN_PAGE;

        try {
            String action = request.getParameter("action");
            if (action == null) {
                url = LOGIN_PAGE;
            } else {
                switch (action) {
                    case "home":
                        request.setAttribute("loginAgain", "You Must Login First !!!");
                        url = LOGIN_PAGE;
                        break;

                    case "Login":
                        try {
                            String username = request.getParameter("username");
                            String password = request.getParameter("password");
                            UserDAO userDAO = new UserDAO();
                            UserDTO user = userDAO.checkLogin(username, password);

                            if (user != null) {
                                HttpSession session = request.getSession();
                                session.setAttribute("user", user);
                                url = "MainController?action=diaryList";
                            } else {
                                request.setAttribute("error", "Incorrect username or password");
                                url = LOGIN_PAGE;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "Logout":
                        try {
                            HttpSession session = request.getSession(false);
                            if (session != null) {
                                session.invalidate();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        url = LOGIN_PAGE;
                        break;

                    case "InputRegister":
                        url = REGISTER_PAGE;
                        break;

                    case "Register":
                        try {
                            String username = request.getParameter("username");
                            String password = request.getParameter("password");
                            String confirmPassword = request.getParameter("confirmPassword");
                            String name = request.getParameter("name");

                            boolean hasError = false;

                            if (username.trim().isEmpty() || password.trim().isEmpty() || name.trim().isEmpty()) {
                                request.setAttribute("error", "All fields are required");
                                hasError = true;
                            } else if (!password.equals(confirmPassword)) {
                                request.setAttribute("error", "Passwords do not match");
                                hasError = true;
                            }

                            if (!hasError) {
                                UserDAO dao = new UserDAO();
                                boolean userExists = dao.checkExistingUser(username);

                                if (userExists) {
                                    request.setAttribute("error", "Username already exists");
                                    url = REGISTER_PAGE;
                                } else {
                                    boolean result = dao.registerUser(username, password, name);
                                    if (result) {
                                        request.setAttribute("success", "Registration successful. Please login.");
                                        url = LOGIN_PAGE;
                                    } else {
                                        request.setAttribute("error", "Registration failed. Please try again.");
                                        url = REGISTER_PAGE;
                                    }
                                }
                            } else {
                                url = REGISTER_PAGE;
                            }
                        } catch (Exception e) {
                            request.setAttribute("error", "Please try again.");
                            url = REGISTER_PAGE;
                        }
                        break;

                    case "diaryList":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                List<DiaryEntryDTO> diaryList = diaryDAO.getUserDiaryEntries(user.getUsername());
                                request.setAttribute("diaryList", diaryList);
                                url = DIARY_LIST;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "CreateDiary":
                        url = CREATE_DIARY;
                        break;

                    case "SaveDiary":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                String entryDateStr = request.getParameter("entryDate");
                                String entryContent = request.getParameter("entryContent");
                                String status = request.getParameter("status");

                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                int newEntryID = diaryDAO.getMaxEntryID() + 1;

                                DiaryEntryDTO newEntry = new DiaryEntryDTO( newEntryID, user.getUsername(), entryDateStr,  entryContent,status );

                                boolean result = diaryDAO.addDiaryEntry(newEntry);
                                if (result) {
                                    request.setAttribute("success", "Diary entry saved successfully!");
                                } else {
                                    request.setAttribute("error", "Failed to save diary entry.");
                                }
                                url = "MainController?action=diaryList";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "ViewDiary":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                String entryIDStr = request.getParameter("entryID");
                                int entryID = Integer.parseInt(entryIDStr);

                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                DiaryEntryDTO entry = diaryDAO.getDiaryEntryById(entryID);

                                if (entry != null && entry.getUsername().equals(user.getUsername())) {
                                    request.setAttribute("diaryEntry", entry);
                                    url = VIEW_DIARY;
                                } else {
                                    request.setAttribute("error", "Diary entry not found or access denied.");
                                    url = "MainController?action=diaryList";
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "EditDiary":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                String entryIDStr = request.getParameter("entryID");
                                int entryID = Integer.parseInt(entryIDStr);

                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                DiaryEntryDTO entry = diaryDAO.getDiaryEntryById(entryID);

                                if (entry != null && entry.getUsername().equals(user.getUsername())) {
                                    request.setAttribute("diaryEntry", entry);
                                    url = EDIT_DIARY;
                                } else {
                                    request.setAttribute("error", "Diary entry not found or access denied.");
                                    url = "MainController?action=diaryList";
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "UpdateDiary":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                String entryIDStr = request.getParameter("entryID");
                                int entryID = Integer.parseInt(entryIDStr);
                                String entryDateStr = request.getParameter("entryDate");
                                String entryContent = request.getParameter("entryContent");
                                 String status = request.getParameter("status");
                                DiaryEntryDTO updatedEntry = new DiaryEntryDTO(  entryID, user.getUsername(), entryDateStr,entryContent, status
                                );

                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                boolean result = diaryDAO.updateDiaryEntry(updatedEntry);

                                if (result) {
                                    request.setAttribute("success", "Diary entry updated successfully!");
                                } else {
                                    request.setAttribute("error", "Failed to update diary entry.");
                                }
                                url = "MainController?action=diaryList";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case "DeleteDiary":
                        try {
                            HttpSession session = request.getSession();
                            UserDTO user = (UserDTO) session.getAttribute("user");

                            if (user == null) {
                                request.setAttribute("loginAgain", "You Must Login First !!!");
                                url = LOGIN_PAGE;
                            } else {
                                String entryIDStr = request.getParameter("entryID");
                                int entryID = Integer.parseInt(entryIDStr);

                                DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                                boolean result = diaryDAO.deleteDiaryEntry(entryID, user.getUsername());

                                if (result) {
                                    request.setAttribute("success", "Diary entry deleted successfully!");
                                } else {
                                    request.setAttribute("error", "Failed to delete diary entry.");
                                }
                                url = "MainController?action=diaryList";
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case "todoList":
                        
                        try {
                            String userName = request.getParameter("userName");
                            DiaryEntryDAO diaryDAO = new DiaryEntryDAO();
                            List<DiaryEntryDTO> dd = diaryDAO.getDoneStatus(userName);
                            request.setAttribute("doneDiaryEntries", dd);
                            
                            url = DONE_LIST;
                        } catch (Exception e) {
                        }
                        break;

                    default:
                        url = LOGIN_PAGE;
                        break;
                }
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}