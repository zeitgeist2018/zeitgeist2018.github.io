/* Change this file to get your personal Porfolio */

// Website related settings
const settings = {
  isSplash: false, // Change this to false if you don't want Splash screen.
};

//SEO Related settings
const seo = {
  title: "Cristian Lobo's Portfolio",
  description: "A software developer who strives to learn every day.",
  og: {
    title: "Cristian Lobo Portfolio",
    type: "website",
    url: "https://cristianlm.es/",
  },
};

//Home Page
const greeting = {
  title: "Cristian Lobo",
  logo_name: "CristianLobo",
  nickname: "zeitgeist2018",
  subTitle: "A software developer who strives to learn every day.",
  resumeLink: "",
  portfolio_repository:
    "https://github.com/zeitgeist2018/zeitgeist2018.github.io",
};

const socialMediaLinks = [
  /* Your Social Media Link */
  // github: "https://github.com/ashutosh1919",
  // linkedin: "https://www.linkedin.com/in/ashutosh-hathidara-88710b138/",
  // gmail: "ashutoshhathidara98@gmail.com",
  // gitlab: "https://gitlab.com/ashutoshhathidara98",
  // facebook: "https://www.facebook.com/laymanbrother.19/",
  // twitter: "https://twitter.com/ashutosh_1919",
  // instagram: "https://www.instagram.com/layman_brother/"

  {
    name: "Github",
    link: "https://github.com/zeitgeist2018",
    fontAwesomeIcon: "fa-github", // Reference https://fontawesome.com/icons/github?style=brands
    backgroundColor: "#181717", // Reference https://simpleicons.org/?q=github
  },
  {
    name: "LinkedIn",
    link: "https://es.linkedin.com/in/cristianlobomartin",
    fontAwesomeIcon: "fa-linkedin-in", // Reference https://fontawesome.com/icons/linkedin-in?style=brands
    backgroundColor: "#0077B5", // Reference https://simpleicons.org/?q=linkedin
  },
  {
    name: "Gmail",
    link: "mailto:cristianlobomartin@gmail.com",
    fontAwesomeIcon: "fa-google", // Reference https://fontawesome.com/icons/google?style=brands
    backgroundColor: "#D14836", // Reference https://simpleicons.org/?q=gmail
  },
];

const skills = {
  data: [
    {
      title: "Full Stack Development",
      fileName: "FullStackImg",
      skills: [
        "⚡ Building highly-available backend systems",
        "⚡ Ensure data integrity and auditability",
        "⚡ Building frontend applications to consume backend",
      ],
      softwareSkills: [
        {
          skillName: "Java",
          fontAwesomeClassname: "simple-icons:java",
          style: {
            color: "#4249d2",
          },
        },
        {
          skillName: "Scala",
          fontAwesomeClassname: "simple-icons:scala",
          style: {
            color: "#d42222",
          },
        },
        {
          skillName: "HTML5",
          fontAwesomeClassname: "simple-icons:html5",
          style: {
            color: "#E34F26",
          },
        },
        {
          skillName: "CSS3",
          fontAwesomeClassname: "fa-css3",
          style: {
            color: "#1572B6",
          },
        },
        {
          skillName: "Sass",
          fontAwesomeClassname: "simple-icons:sass",
          style: {
            color: "#CC6699",
          },
        },
        {
          skillName: "JavaScript",
          fontAwesomeClassname: "simple-icons:javascript",
          style: {
            backgroundColor: "#000000",
            color: "#F7DF1E",
          },
        },
        {
          skillName: "ReactJS",
          fontAwesomeClassname: "simple-icons:react",
          style: {
            color: "#61DAFB",
          },
        },
        {
          skillName: "NPM",
          fontAwesomeClassname: "simple-icons:npm",
          style: {
            color: "#CB3837",
          },
        },
        {
          skillName: "Webpack",
          fontAwesomeClassname: "simple-icons:webpack",
          style: {
            color: "#2C8EBB",
          },
        },
        {
          skillName: "Gradle",
          fontAwesomeClassname: "simple-icons:gradle",
          style: {
            color: "#3a43ba",
          },
        },
        {
          skillName: "Postgres",
          fontAwesomeClassname: "simple-icons:postgresql",
          style: {
            color: "#02569B",
          },
        },
        {
          skillName: "Docker",
          fontAwesomeClassname: "simple-icons:docker",
          style: {
            color: "#02569B",
          },
        },
      ],
    },
    {
      title: "Cloud Infrastructure",
      fileName: "CloudInfraImg",
      skills: [
        "⚡ Experience working on Amazon Web Services",
        "⚡ Building custom architectures for specific solutions",
      ],
      softwareSkills: [
        {
          skillName: "AWS",
          fontAwesomeClassname: "simple-icons:amazonaws",
          style: {
            color: "#FF9900",
          },
        },
        {
          skillName: "PostgreSQL",
          fontAwesomeClassname: "simple-icons:postgresql",
          style: {
            color: "#336791",
          },
        },
        {
          skillName: "Docker",
          fontAwesomeClassname: "simple-icons:docker",
          style: {
            color: "#1488C6",
          },
        },
        {
          skillName: "Kubernetes",
          fontAwesomeClassname: "simple-icons:kubernetes",
          style: {
            color: "#326CE5",
          },
        },
      ],
    },
  ],
};

// Education Page
const competitiveSites = {
  competitiveSites: [
    {
      siteName: "HackerRank",
      iconifyClassname: "simple-icons:hackerrank",
      style: {
        color: "#2EC866",
      },
      profileLink: "https://www.hackerrank.com/layman_brother",
    },
    {
      siteName: "Codechef",
      iconifyClassname: "simple-icons:codechef",
      style: {
        color: "#5B4638",
      },
      profileLink: "https://www.codechef.com/users/ashutosh_1919",
    },
    {
      siteName: "Codeforces",
      iconifyClassname: "simple-icons:codeforces",
      style: {
        color: "#1F8ACB",
      },
      profileLink: "http://codeforces.com/profile/layman_brother",
    },
    {
      siteName: "Hackerearth",
      iconifyClassname: "simple-icons:hackerearth",
      style: {
        color: "#323754",
      },
      profileLink: "https://www.hackerearth.com/@ashutosh391",
    },
    {
      siteName: "Kaggle",
      iconifyClassname: "simple-icons:kaggle",
      style: {
        color: "#20BEFF",
      },
      profileLink: "https://www.kaggle.com/laymanbrother",
    },
  ],
};

const degrees = {
  degrees: [
    {
      title: "Superior multiplatform application development",
      subtitle: "IES Enrique Tierno Galván - Parla (Madrid)",
      logo_path: "education.svg",
      alt_name: "",
      duration: "2016 - 2018",
      descriptions: [
        "⚡ I have studied basic software engineering topics like Databases, OOP, UI/UX, Android, Javascript, etc",
      ],
      website_link:
        "https://www.comunidad.madrid/sites/default/files/doc/educacion/fp/FP-Ensenanza-IFCS02-LOE-Ficha.pdf",
    },
    {
      title: "Anti-hacking software development",
      subtitle: "CFTIC - Getafe (Madrid)",
      logo_path: "education.svg",
      alt_name: "",
      duration: "2018 - 2018",
      descriptions: [
        "⚡ I learned different technics to develop secure web applications",
      ],
      website_link: "",
    },
    {
      title: "Superior electronic equipment development",
      subtitle: "IES Satafi - Getafe (Madrid)",
      logo_path: "education.svg",
      alt_name: "",
      duration: "2010 - 2012",
      descriptions: [
        "⚡ I have studied all the different electronic components, and designed different hardware like factory controllers, robots, etc",
      ],
      website_link: "",
    },
    {
      title: "Consumer electronic equipments",
      subtitle: "IES Azarquiel - Toledo",
      logo_path: "education.svg",
      alt_name: "",
      duration: "2007 - 2009",
      descriptions: [
        "⚡ I have studied the basics of electronics and electricity",
      ],
      website_link: "",
    },
  ],
};

const certifications = {
  certifications: [
    {
      title: "Java SE 8 Programmer I",
      subtitle: "- Oracle",
      logo_path: "Oracle-Logo.png",
      certificate_link: "",
      alt_name: "GCP",
      color_code: "#ffffff",
    },
    {
      title: "Certified ScrumMaster® (CSM®)",
      subtitle: "- Scrum Alliance",
      logo_path: "scrum_alliance_logo.png",
      certificate_link: "https://bcert.me/svfmsegsn",
      alt_name: "GCP",
      color_code: "#ffffff",
    },
  ],
};

// Experience Page
const experience = {
  title: "Experience",
  subtitle: "",
  description: "",
  header_image_path: "experience.svg",
  sections: [
    {
      title: "Work",
      experiences: [
        {
          title: "Professional backend engineer",
          company: "Zooplus",
          company_url: "https://zooplus.co.uk/",
          logo_path: "zooplus_logo.png",
          duration: "July 2018 - PRESENT",
          location: "Madrid, Spain",
          description:
            "Java/Scala/Angular/React Developer mainly, making use of all kinds of technologies and frameworks like Java Spark, Akka, Spring, Jenkins, Docker, MyBatis, AWS, Oracle DB, Postgresql, etc." +
            "Scrum methodology, and use of tools like Git, Swagger, Grafana/Kibana, etc." +
            "Continuous use of the English language, both spoken and written." +
            "Mentoring to junior devs, and help in recruiting process.",
          color: "#29d243",
        },
        {
          title: "Software development apprenticeship",
          company: "GFI",
          company_url: "https://gfi.world",
          logo_path: "gfi_logo.png",
          duration: "Apr 2018 - July 2018",
          location: "Madrid, Spain",
          description:
            "Web application development with Spring Boot, Spring Security, Thymeleaf and Oracle Database.",
          color: "#f69f55",
        },
        {
          title: "Software developer",
          company: "Electrónica Chanzi",
          company_url: "",
          logo_path: "engineer.png",
          duration: "Nov 2016 - Nov 2017",
          location: "Madrid, Spain",
          description:
            "Design and development of equipment for automatic cash-handling machines. The software consisted on an native Android app, a C# app for the machine low-level control, and a PHP/MySQL backend.",
          color: "#ff4959",
        },
        {
          title: "Workshop engineer",
          company: "Cubic Transportation Systems",
          company_url: "",
          logo_path: "cubic_logo.png",
          duration: "Dev 2014 - Sep 2016",
          location: "Crawley, UK",
          description:
            "Maintenance and repairs of all kind of appliances related to the London Underground and other rail services." +
            "Working at component level and offering a high standard level on each repair.",
          color: "#ff4959",
        },
        {
          title: "IT Technician",
          company: "Mexxo LTD",
          company_url: "",
          logo_path: "engineer.png",
          duration: "Aug 2014 - Nov 2014",
          location: "London, UK",
          description: "Personal computer repairs",
          color: "#ff4959",
        },
      ],
    },
  ],
};

// Projects Page
const projectsHeader = {
  title: "Projects",
  description:
    "My projects makes use of vast variety of latest technology tools. My best experience is to create Data Science projects and deploy them to web applications using cloud infrastructure.",
  avatar_image_path: "projects_image.svg",
};

// Contact Page
const contactPageData = {
  contactSection: {
    title: "Contact Me",
    profile_image_path: "cristian.jpeg",
    description: "",
  },
  blogSection: {
    title: "Blogs",
    subtitle: "",
    link: "",
    avatar_image_path: "blogs_image.svg",
  },
  addressSection: {
    title: "Address",
    subtitle: "Madrid - Spain",
    avatar_image_path: "address_image.svg",
    location_map_link: "https://goo.gl/maps/FQ7L3RSe1Az6thzcA",
  },
  phoneSection: {
    title: "Email",
    subtitle: "cristianlobomartin@gmail.com",
  },
};

export {
  settings,
  seo,
  greeting,
  socialMediaLinks,
  skills,
  competitiveSites,
  degrees,
  certifications,
  experience,
  projectsHeader,
  contactPageData,
};
