pushd ./backend
nohup nodemon &
popd
pushd ./frontend
nohup ng serve &&
popd
