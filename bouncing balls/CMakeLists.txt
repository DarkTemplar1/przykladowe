cmake_minimum_required(VERSION 3.27)
project(bouncing_balls)

set(CMAKE_CXX_STANDARD 17)

include_directories(C:/Users/skalk/OneDrive/Pulpit/GLgui.h/include)

link_directories(C:/Users/skalk/OneDrive/Pulpit/GLgui.h/lib)

add_executable(bouncing_balls main.cpp ball.cpp eventHandling.cpp gui.cpp imageloader.cpp)

target_link_libraries(bouncing_balls libglui.a)