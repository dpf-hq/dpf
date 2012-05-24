function createTextImage( el ) {
	var elText = el.get( 'text' );
	el.empty();
	var tagname = el.tagName.toLowerCase();
	var classRegex = /textimage-([a-z0-9-]+)/;
	var classMatch = classRegex.exec( el.className );
	if ( classMatch ) tagname = classMatch[1];
    var file = Base64.encode( elText );
    file = file.replace('+', '-');
    file = file.replace('/', '_');
	new Element( 'img', { 'src': THEME_IMAGE_DIR + '/dynamic/' + tagname + '/' + file + '.png', 'alt': elText } ).inject( el );
}

var WebCodeForm = new Class({
	webcodes: {
		'bklt2010': 'http://markusstudiert.de/booklet/',
		'3pYKad': 'http://googleblog.blogspot.com/2009/07/google-apps-is-out-of-beta-yes-really.html',
		'eZ5GI': 'http://gmailblog.blogspot.com/2009/07/gmail-leaves-beta-launches-back-to-beta.html',
		'wikipedia': 'http://de.wikipipedia.org/',
		'kottke': 'http://kottke.org/',
		'facebook': 'http://facebook.com/',
		'zwonull': 'http://tacker.medieninformatiker.info/s1/gg/referat/',
		'wave': 'http://wave.google.com/',
		'rgb': 'http://de.wikipedia.org/wiki/RGB-Farbraum',
		'euroskala': 'http://de.wikipedia.org/wiki/Euroskala',
		'processing': 'http://de.wikipedia.org/wiki/Processing',
		'4Yw52u': 'http://www.heise.de/ct/ftp/07/24/206/',
		'trees': 'http://www.openprocessing.org/visuals/?visualID=2925'
	},
	initialize: function()
	{
		$('webcodeform').addEvent('submit', this.submitHandler.bind(this));
		$('webcode').addEvent('keyup', this.keyHandler.bind(this));
	},
	keyHandler: function(ev)
	{
		if (ev.key === 'enter') $('webcodeform').fireEvent('submit');
	},
	submitHandler: function(ev)
	{
		if (ev) ev.preventDefault();
		var webcodes = new Hash(this.webcodes);
		var code = $('webcode').get('value');
		if (webcodes.has(code)) window.location.href = webcodes.get(code);
	}
});

var Link2Video = new Class({
	initialize: function() {
		var swfLinks = $$('a[href$=".swf"]');
		var swfLinksN = swfLinks.length;
		while(swfLinksN--) {
			var cLink = swfLinks[swfLinksN];
			var fLink = new FlashLinkVideo(cLink);
			var divId = 'flash-' + swfLinksN;
			new Element('div', {'id': divId}).inject(cLink, 'after');
			new Element('h3', {'class': 'textimage', 'text': cLink.get('text')}).inject(cLink, 'after');
			swfobject.embedSWF(cLink.get('href'), divId, fLink.getWidth(), fLink.getHeight(), '9.0.0');
			cLink.destroy();
		}
	}
});

var FlashLinkVideo = new Class({
	width: 500,
	ratio: 16/9,
	link: null,
	initialize: function(link) {
		this.link = link;
		this.parseRel();
		
	},
	getRatio: function()
	{
		return this.ratio;
	},
	getWidth: function()
	{
		return this.width;
	},
	getHeight: function()
	{
		return Math.floor(this.getWidth() * (1 / (this.getRatio())));
	},
	parseRel: function() 
	{
		var linkRel = this.link.get('rel');
		if (!linkRel) return;
		var paramMatch = linkRel.match('flash\\[([^\\]]+)\\]');
		if (!paramMatch) return;
	    	var params = paramMatch[1].split('&');
	    	var pLen = params.length;
	    	while(pLen--) {
			var pDef = params[pLen].split("=");
			if (pDef.length == 2) this.handleParam(pDef[0], pDef[1]);
	    	}
	},
	handleParam: function(param, arg)
	{
		switch(param) {
		case 'ar':
			var ratioMatch = arg.match('^([0-9]+)/([0-9]+)$');
			if (ratioMatch) {
				this.ratio = parseInt(ratioMatch[1], 10) / parseInt(ratioMatch[2], 10);
			}
			break;
		case 'w':
			this.width = parseInt(arg, 10);
			break;
		}
	}	
});

window.addEvent('domready', function() {

  	$$('h1').addEvent('click', function(ev) {
    	document.location.href = '/';
   	});

	new Link2Video();

    var ie6 = (Browser.Engine.trident && parseInt(Browser.Engine.version) === 4);
    if (!ie6) {
        new Asset.css(THEME_CSS_DIR + '/chrome.css?4', {'media': 'screen'});

    	// Text-Images
    	$$( '.textimage' ).each( function( el ) {
    		createTextImage( el );
      	} );

	// Bade
	var jbsw = new Element('a', {'href': 'http://markusstudiert.de/achievement-unlocked', 'title': 'Jöndhard Biffel Softwaretechnik Wanderpreis', 'id': 'jbswbadge'});
	jbsw.inject($$('h1')[0], 'after');
    }

    // Webcodes
    if ($('webcodeform')) new WebCodeForm();
});
