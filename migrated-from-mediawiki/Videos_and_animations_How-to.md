# Introduction
There are many programs which can capture what you are doing on the screen and turn it into a video which can be viewed on Youtube. The problem with Freeplane maps in following this procedure is:

* the resolution of the video is too low to be able to read the content of Freeplane's nodes;
* the amount of memory stored is disproportionally large. 

The following describes a procedure which keeps the resolution necessary for crisp, readable mind maps and takes a minimum amount of storage space.

# Wink
The program used is [which is a free software. Wink captures the screen and the position of the mouse cursor independently from each other.  To see the cursor moving on the screen, only the begin and end points of the cursor are stored. If besides the cursor, the screen is not changing, only one screen is captured during the whole movement. Next when running the video Wink displays the screen and (re)generates the cursor movements. Each screenshot can be extended with call outs, images and recorded sounds giving an impression of a running animation or video - in the full resolution in which the screen is captured. The result can be rendered into flash. A special version could be converted to whatever format you need (e.g. mp4 or avi), although it is not clear you would want this if you are using a computer.

# Principle
In the following a standard procedure is developed which:

* makes sure the Freeplane map is readable enough;
* helps to minimize the work involved;
* makes possible to reorganize and adapt a recording at a later time;
* gives the best result if conversion to a video format or YouTube is necessary.

For this setting and procedure a supporting html file is provided which will make sure the flash file is displayed the best possible way.

# Solution 1: source animation or video

* Define a directory with the name of the video you are going to make, e.g. myVideo. 
* Download [http://www.debugmode.com/wink/**Wink**](http://www.debugmode.com/wink/|**Wink**],). Read its instruction.
* Open Wink
* Select File > New.
* Select fixed screen size of 1280 x 720 (HD), e.g. window region 31,10 x 1310,729. Markers are shown which indicate this area.
* Open Freeplane. Make Freeplane window fit exactly within the capture area shown by Wink.
* Select input driven capture rate at mouse click, key press
* Minimize Wink
* Use Alt + Pause to start/stop input driven capture; or use Pause for a single screen shot.
* When finished, render video for Macromedia flash (or if you want to convert it later to mpeg4 of avi, Macromedia uncompressed).
* Save the generated files in directory myVideo. The files generated are: myVideo.htm, myVideo.sfw and myVideo.js.
* Rename myVideo.htm into w1280x720.html
* Use the procedure below to create file index.html and copy it into directory myVideo.
* If you want to view the video on your computer, start index.html; or
* If you want to use the video on your webserver, upload the directory myVideo to your webserver. The video starts if you address .../myVideo; this will automatically call index.html which will do its thing and call w1280x720.html.

N.B.1 The flash file generated should not be called right away, because image quality will be terrible because of resizing.<br>
N.B.2 In stead of copying index.html to myVideo, you could rename myVideo.htm to index.html (in stead of renaming it to w1280x720.html). In that case your browser will take more place on the screen and the video must be scrolled vertically more frequently if your screen is too small.

# Create file index.html
The wink video is played in your browser. The file index.html makes sure the viewing window for the wink video is maximal (it opens a new window) and that it is set to a fixed size which gives best video quality. For this the directory where you keep your video, e.g. .../myVideo, must contain a file index.html (see the above procedure). The content of this file is shown below. Copy the following text to an editor such as Notepad and save it as index.html:

`
<HTML>
<HEAD>
<script>
function wopen(url, name, w, h)
{
w += 32;
h += 96;
    var win = window.open(url,
    name,
    'width=' + w + ', height=' + h + ', ' +
    'location=no, menubar=no, ' +
    'status=no, toolbar=no, scrollbars=yes, resizable=yes');
    win.resizeTo(w, h);
    win.focus();
}
</script> 
</HEAD>
<BODY>
<a href="w1280x720.html" target="popup"
    onClick="wopen('w1280x720.html', 'popup', 1300, 760); return false;"> Click here to open the page in a new window. </a> 
</BODY>
</HTML>

`

# Example
The following [video](http://www.freeplane.org/doc/1.2.x/Instruction/ViewingGuide) was created this way. http://www.freeplane.org/mapsOnline/video contains other examples. <br><br>

Dowload and unzip [this **example**](http://www.freeplane.org/mapsOnline/video/myVideo.zip). Execute *index.html* for the (compressed) wink video. Run *myVideo.mpg* to see the same video if converted to mpg with iWisoft. Note the difference in file sizes.

# Solution 2: convert to mpeg, avi
## a. plain convert
With solution 1 the basic animation/video is created. Once this has been tested and is final, it is possible to convert it to a HD quality mepg 4 or avi video:

* render the wink project a second time, with in "Project settings" (icon in top bar) option "Macromedia uncompressed".
* convert the resulting flash file with a free flash to mpeg convertor. Important: not every conversion program correctly converts the pauses which may be set. As an example, capture the wink video using iwIsoft. (The free version of wWisoft has an iWisof icon on the screen)

The resulting mpeg 4 can be played on your TV/video system, or uploaded to YouTube.<br>
N.B.1 Set the conversion options for optimal resolution. The procedure described focusses on HD-quality.<br>
N.B.2 The image quality is less and the size of the file is much larger than the file produced in solution 1.<br>
N.B.3 The video will fit the whole screen and doesn't need scrolling.

## b. 2nd screencapture
It is possible to play the wink video from solution 1 and capture it with a program of your choice, e.g.  Microsoft Expression Encoder 4 Screen Capture and next encode it with Microsoft Expression Encoder 4. (This solution has no iWisoft icon on the screen.)

# Hints for working with Wink

* Wink allows you to record single frames. Wink also allows to record and handle scenes (a number of frames) independently and add together the scenes only when you have tested and finished each scene. This makes editing and testing faster.
* The movement of the cursor can be set or changed AFTER the recording of a scene. Just drag the cursor (rectangle + cursor in the frame) to its begin or end point. In this way scenes can be connected with the cursor going as you want it. If a cursor is missing, just copy it from another frame and paste it in the frame where the cursor is missing. Next move it to the position you want. If you connect different recording, copy the cursor of the prior scene into the current scene to prevent the cursor to move unexpectedly.
* To change a scene, you may rerecord part of it and copy and paste the selected frames into the old scene. The duration of each frame can be set AFTER the recording. Also labels and images may be added AFTER the recording. This makes designing and editing scenes flexible and productive. A narrative or sound can be added AFTER recording. If necessary adapt the duration of the frame the sound is in.
* After recording you may have frames in which nothing changes. These frames may be deleted. This makes editing more easy and keeps the size of the Wink video very small.
* The cursor may be changed. Select the cursor and in the right dialog load and select the mouse cursor icon. A practicle use is to duplicate (copy and paste) the frame where the mouseclick should happen. Next in the first of the two identical frames, change the cursor to the mouse cursor and set the time of this frame to 1 second.  
* Keypresses can be added in the same way as the above mousecursor. Alternatively keys may be added as images. Again duplicate the frame where the key should be shown, load the key image in the first image, and set the time to 1 second.

