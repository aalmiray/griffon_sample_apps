hbox {
    border(styles: "{padding:2}") {
         vbox(styles: "{padding:{top:2, left:4, bottom:4, right:4}, spacing:10}") {
               vbox {
                  label("Basic Push Buttons", styles: "{font:{bold:true}}")
                  hbox {
                     button("One")
                     button("Two")
                     button("Three", enabled: false)
                  }
               }

               vbox {
                  label("Ungrouped Toggle Buttons", styles: "{font:{bold:true}}")
                  hbox {
                     button("One", toggleButton: true)
                     button("Two", toggleButton: true)
                     button("Three", toggleButton: true, enabled: false)
                  }
               }

               vbox {
                  label("Grouped Toggle Buttons", styles: "{font:{bold:true}}")
                  hbox {
                     buttonGroup(id: "toggleButtons")
                     button("One", toggleButton: true, buttonGroup: toggleButtons)
                     button("Two", toggleButton: true, buttonGroup: toggleButtons)
                     button("Three", toggleButton: true, buttonGroup: toggleButtons, selected: true, enabled: false)
                  }
               }

               vbox {
                  label("Image Buttons", styles: "{font:{bold:true}}")
                  hbox {
                     button {
                           buttonData(icon: "bell.png", text: "Bell")
                     }
                     button {
                           buttonData(icon: "clock.png", text: "Clock")
                           buttonDataRenderer(orientation: "vertical")
                     }
                     button(enabled: false) {
                           buttonData(icon: "house.png", text: "House")
                     }
                  }
               }

               vbox {
                  label("Toolbar Buttons", styles: "{font:{bold:true}}")
                  hbox {
                     button(styles: "{toolbar:true}") {
                           buttonData(icon: "bell.png")
                     }
                     button(styles: "{toolbar:true}") {
                           buttonData(icon: "clock.png")
                     }
                     button(enabled: false, styles: "{toolbar:true}") {
                           buttonData(icon: "house.png")
                     }
                  }
               }
         }
    }

    border(styles: "{padding:2}") {
            vbox(styles: "{padding:{top:2, left:4, bottom:4, right:4}, spacing:10}") {
                vbox {
                    label("Basic Radio Buttons", styles: "{font:{bold:true}}")
                    hbox {
                        buttonGroup(id: "radioButtons")
                        radioButton("One", buttonGroup: radioButtons)
                        radioButton("Two", buttonGroup: radioButtons)
                        radioButton("Three", buttonGroup: radioButtons, selected: true, enabled: false)
                    }
                }

                vbox {
                    label("Image Radio Buttons", styles: "{font:{bold:true}}")
                    vbox {
                        buttonGroup(id: "imageRadioButtons")
                        radioButton(buttonGroup: imageRadioButtons) {
                             buttonData(icon: "bell.png", text: "Bell")
                        }
                        radioButton(buttonGroup: imageRadioButtons) {
                             buttonData(icon: "clock.png", text: "Clock")
                        }
                        radioButton(buttonGroup: imageRadioButtons, selected: true, enabled: false) {
                             buttonData(icon: "house.png", text: "House")
                        }
                    }
                }
            }
    }

    border(styles: "{padding:2}") {
            vbox(styles: "{padding:{top:2, left:4, bottom:4, right:4}, spacing:10}") {
                vbox {
                    label("Basic Checkboxes", styles: "{font:{bold:true}}")
                    hbox {
                        checkbox("One")
                        checkbox("Two")
                        checkbox("Three", selected: true, enabled: false)
                    }
                }

                vbox {
                    label("Image Checkboxes", styles: "{font:{bold:true}}")
                    vbox {
                        checkbox {
                             buttonData(icon: "clock.png", text: "Clock")
                        }
                        checkbox {
                             buttonData(icon: "bell.png", text: "Bell")
                        }
                        checkbox(selected: true, enabled: false) {
                             buttonData(icon: "house.png", text: "House")
                        }
                    }
                }

                vbox {
                    label("Tri-state Checkboxes", styles: "{font:{bold:true}}")
                    vbox {
                        checkbox("Read", triState: true, state: "selected")
                        checkbox("Write", triState: true, state: "unselected")
                        checkbox("Execute", triState: true, state: "mixed", enabled: false)
                    }
                }
            }
    }

    border(styles: "{padding:2}") {
            vbox(styles: "{padding:{top:2, left:4, bottom:4, right:4}, spacing:10}") {
                vbox {
                    label("Basic Link Buttons", styles: "{font:{bold:true}}")
                    hbox {
                        linkButton("One")
                        linkButton("Two")
                        linkButton("Three", enabled: false)
                    }
                }

                vbox {
                    label("Image Link Buttons", styles: "{font:{bold:true}}")
                    vbox {
                        linkButton {
                             buttonData(icon: "bell.png", text: "Bell")
                        }
                        linkButton {
                             buttonData(icon: "clock.png", text: "Clock")
                        }
                        linkButton(enabled: false) {
                             buttonData(icon: "house.png", text: "House")
                        }
                    }
                }
            }
    }
}
