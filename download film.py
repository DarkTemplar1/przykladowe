from pytube import YouTube

link =input('Enter link: ')
yt=YouTube(link)
print(" video",yt.title,"title of the video")
yd=yt.streams.get_highest_resolution()
#place to put in the download
yd.download('C:/Users/skalk/OneDrive/Pulpit/folder')